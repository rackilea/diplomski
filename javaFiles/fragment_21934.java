package org.apache.commons.net.ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLSocket;

import org.apache.commons.net.util.Base64;

/**
 * Experimental attempt at FTPS client that tunnels over an HTTP proxy connection.
 *
 * @author TECBMJNA
 * @created 22/07/2015 09:29:45
 */
public class FTPSHTTPClient extends FTPSClient {

    private final String proxyHost;
    private final int proxyPort;
    private final String proxyUsername;
    private final String proxyPassword;

    private String tunnelHost; // Save the host when setting up a tunnel (needed for EPSV)

    private static final byte[] CRLF = { '\r', '\n' };
    private final Base64 base64 = new Base64();

    /**
     * Constructor with proxy authentication
     *
     * @param proxyHost
     * @param proxyPort
     * @param proxyUser
     * @param proxyPass
     *
     * @author TECBMJNA
     * @created 22/07/2015 10:06:04
     */
    public FTPSHTTPClient(String proxyHost, int proxyPort, String proxyUser, String proxyPass) {
        super();
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.proxyUsername = proxyUser;
        this.proxyPassword = proxyPass;
        this.tunnelHost = null;

        //TECBMJNA so funciona a partir do Java 8, pois Java 8 aceita proxy HTTP
        //setProxy(new Proxy(Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
    }

    /**
     * Default constructor
     *
     * @param proxyHost
     * @param proxyPort
     *
     * @author TECBMJNA
     * @created 22/07/2015 10:06:14
     */
    public FTPSHTTPClient(String proxyHost, int proxyPort) {
        this(proxyHost, proxyPort, null, null);
    }

    /**
     *
     * @see org.apache.commons.net.ftp.FTPSClient#_openDataConnection_(java.lang.String, java.lang.String)
     */
    @Override
    protected Socket _openDataConnection_(String command, String arg) throws IOException {
        //Force local passive mode, active mode not supported by through proxy
        if (getDataConnectionMode() != PASSIVE_LOCAL_DATA_CONNECTION_MODE) {
            throw new IllegalStateException("Only passive connection mode supported");
        }

        final boolean isInet6Address = getRemoteAddress() instanceof Inet6Address;
        String passiveHost = null;

        // Try EPSV command first on IPv6 - and IPv4 if enabled.
        // When using IPv4 with NAT it has the advantage
        // to work with more rare configurations.
        // E.g. if FTP server has a static PASV address (external network)
        // and the client is coming from another internal network.
        // In that case the data connection after PASV command would fail,
        // while EPSV would make the client succeed by taking just the port.
        boolean attemptEPSV = isUseEPSVwithIPv4() || isInet6Address;

        if (attemptEPSV && epsv() == FTPReply.ENTERING_EPSV_MODE) {
            _parseExtendedPassiveModeReply(_replyLines.get(0));
            passiveHost = this.tunnelHost;
        } else {
            if (isInet6Address) {
                return null; // Must use EPSV for IPV6
            }

            // If EPSV failed on IPV4, revert to PASV
            if (pasv() != FTPReply.ENTERING_PASSIVE_MODE) {
                return null;
            }

            _parsePassiveModeReply(_replyLines.get(0));
            passiveHost = this.getPassiveHost();
        }

        Socket proxySocket = new Socket();

        if (getReceiveDataSocketBufferSize() > 0) {
            proxySocket.setReceiveBufferSize(getReceiveDataSocketBufferSize());
        }

        if (getSendDataSocketBufferSize() > 0) {
            proxySocket.setSendBufferSize(getSendDataSocketBufferSize());
        }

        if (getPassiveLocalIPAddress() != null) {
            proxySocket.bind(new InetSocketAddress(getPassiveLocalIPAddress(), 0));
        }

        if (getDataTimeout() >= 0) {
            proxySocket.setSoTimeout(getDataTimeout());
        }

        proxySocket.connect(new InetSocketAddress(proxyHost, proxyPort), getConnectTimeout());

        tunnelHandshake(passiveHost, this.getPassivePort(), proxySocket.getInputStream(),
                        proxySocket.getOutputStream());

        Socket socket = getContext().getSocketFactory().createSocket(proxySocket, passiveHost,
                                                                     this.getPassivePort(), true);

        if (getReceiveDataSocketBufferSize() > 0) {
            socket.setReceiveBufferSize(getReceiveDataSocketBufferSize());
        }

        if (getSendDataSocketBufferSize() > 0) {
            socket.setSendBufferSize(getSendDataSocketBufferSize());
        }

        if (getPassiveLocalIPAddress() != null) {
            socket.bind(new InetSocketAddress(getPassiveLocalIPAddress(), 0));
        }

        if (getDataTimeout() >= 0) {
            socket.setSoTimeout(getDataTimeout());
        }

        if ((getRestartOffset() > 0) && !restart(getRestartOffset())) {
            proxySocket.close();
            socket.close();
            return null;
        }

        if (!FTPReply.isPositivePreliminary(sendCommand(command, arg))) {
            proxySocket.close();
            socket.close();
            return null;
        }

        if (socket instanceof SSLSocket) {
            SSLSocket sslSocket = (SSLSocket) socket;

            sslSocket.setUseClientMode(getUseClientMode());
            sslSocket.setEnableSessionCreation(getEnableSessionCreation());

            // server mode
            if (!getUseClientMode()) {
                sslSocket.setNeedClientAuth(getNeedClientAuth());
                sslSocket.setWantClientAuth(getWantClientAuth());
            }

            if (getEnabledCipherSuites() != null) {
                sslSocket.setEnabledCipherSuites(getEnabledCipherSuites());
            }

            if (getEnabledProtocols() != null) {
                sslSocket.setEnabledProtocols(getEnabledProtocols());
            }
            sslSocket.startHandshake();
        }

        return socket;
    }

    /**
     *
     * @see org.apache.commons.net.SocketClient#connect(java.lang.String, int)
     */
    @Override
    public void connect(String host, int port) throws SocketException, IOException {

        _socket_ = new Socket(proxyHost, proxyPort);
        _input_ = _socket_.getInputStream();
        _output_ = _socket_.getOutputStream();

        try {
            tunnelHandshake(host, port, _input_, _output_);
        } catch (Exception e) {
            IOException ioe = new IOException("Could not connect to " + host + " using port " + port);
            ioe.initCause(e);
            throw ioe;
        }

        super._connectAction_();
    }

    /**
     * Tunnels FTPS client connection over an HTTP proxy connection
     *
     * @param host
     * @param port
     * @param input
     * @param output
     * @throws IOException
     * @throws UnsupportedEncodingException
     *
     * @author TECBMJNA
     * @created 22/07/2015 09:32:23
     */
    private void tunnelHandshake(String host, int port, InputStream input, OutputStream output) throws IOException,
            UnsupportedEncodingException {
        final String connectString = "CONNECT " + host + ":" + port + " HTTP/1.1";
        final String hostString = "Host: " + host + ":" + port;

        this.tunnelHost = host;
        output.write(connectString.getBytes("UTF-8")); // TODO what is the correct encoding?
        output.write(CRLF);
        output.write(hostString.getBytes("UTF-8"));
        output.write(CRLF);

        if (proxyUsername != null && proxyPassword != null) {
            final String auth = proxyUsername + ":" + proxyPassword;
            final String header = "Proxy-Authorization: Basic " + base64.encodeToString(auth.getBytes("UTF-8"));
            output.write(header.getBytes("UTF-8"));
        }

        output.write(CRLF);
        output.flush();

        List<String> response = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, getCharsetName())); // Java 1.6 can use getCharset()

        for (String line = reader.readLine(); line != null && line.length() > 0; line = reader.readLine()) {
            response.add(line);
        }

        int size = response.size();

        if (size == 0) {
            throw new IOException("No response from proxy");
        }

        String code = null;
        String resp = response.get(0);

        if (resp.startsWith("HTTP/") && resp.length() >= 12) {
            code = resp.substring(9, 12);
        } else {
            throw new IOException("Invalid response from proxy: " + resp);
        }

        if (!"200".equals(code)) {
            StringBuilder msg = new StringBuilder();
            msg.append("HTTPTunnelConnector: connection failed\r\n");
            msg.append("Response received from the proxy:\r\n");

            for (String line : response) {
                msg.append(line);
                msg.append("\r\n");
            }

            throw new IOException(msg.toString());
        }
    }

}