import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.Base64;
import java.util.Base64.Encoder;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.*;

public class EmailClient
{
    private SSLSocket socket;

    private BufferedReader br;
    private OutputStream os;

    private String lastResponseText;

    private void checkReplyCode(int replyCode, int expectedReplyCode)
    {
        if (replyCode != expectedReplyCode)
            throw new Exception(lastResponseText);
    }

    private int checkReplyCodes(int replyCode, int expectedReplyCodes[])
    {
        if (expectedReplyCodes == null)
            return replyCode;

        for (int i = 0; i < expectedReplyCodes.length; ++i)
        {
            if (replyCode == expectedReplyCodes[i])
                return replyCode;
        }

        throw new Exception(lastResponseText);
    }

    private int readResponse()
    {
        lastResponseText = "";

        String line = br.readLine();
        System.out.println(line);

        lastResponseText = line;

        if ((line.length() > 3) && (line[3] == '-'))
        {
            String prefix = line.substring(0, 4);
            do
            {
                line = br.readLine();
                System.out.println(line);
                lastResponseText += ("\r\n" + line.substring(4));
            }
            while (line.startsWith(prefix));
        }

        return Integer.parseInt(lastResponseText.substring(0, 3));
    }

    private void readResponse(int expectedReplyCode)
    {
        checkReplyCode(readResponse(), expectedReplyCode);
    }

    private int readResponse(int expectedReplyCodes[])
    {
        return checkReplyCodes(readResponse(), expectedReplyCodes);
    }

    private void sendLine(String line)
    {
        System.out.println(line);
        os.write((line + "\r\n").getBytes("US-ASCII"));
    }

    private int sendCommand(String command)
    {
        sendLine(command);
        return readResponse();
    }

    private void sendCommand(String command, int expectedReplyCode)
    {
        sendLine(command);
        readResponse(expectedReplyCode);
    }

    private int sendCommand(String command, int expectedReplyCodes[])
    {
        sendLine(command);
        return readResponse(expectedReplyCodes);
    }

    private String stringAsBase64(String data)
    {
        return Base64.getEncoder().encodeToString(data.getBytes("UTF-8"));
    }

    public static void main(String[] args) throws Exception
    {
        // Establish a TCP connection with the mail server.
        socket = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(InetAddress.getByName("smtp.gmail.com"), 465);

        // Create a BufferedReader to read a line at a time.
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Get a reference to the socket's output stream.
        os = socket.getOutputStream();

        // Read greeting from the server.
        readResponse(220);

        // Send HELO command and get server response.
        //sendCommand("HELO alice", 250);
        sendCommand("EHLO alice", 250);

        // Authentication
        sendCommand("AUTH LOGIN", 334);

        /* encoding the username and password in Base64 for SMTP */
        if (sendCommand(stringAsBase64("username"), new int[]{235, 334}) == 334)
            sendCommand(stringAsBase64("password"), 235);

        // Send MAIL FROM command.
        sendCommand("MAIL FROM: <xxxxxxxx@gmail.com>", 250);

        // Send RCPT TO command.
        sendCommand("RCPT TO:<xxxxxxxxxx.com>", 250);

        // Send DATA command.
        sendCommand("DATA", 354);

        // Send message data.
        sendLine("From: <xxxxxxxx@gmail.com>");
        sendLine("To: <xxxxxxxxxx.com>");
        sendLine("Subject: Test");
        sendLine("");
        sendLine("email sent");

        // End with line with a single period.
        sendCommand(".", 250);

        // Send QUIT command.
        sendCommand("QUIT", 221);

        socket.close();
    }
}