import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;


public class SServidor {   


public SServidor(){
    try {
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        File keystrorefile = new File("/path/name_store.jks");
        System.out.println(keystrorefile.getAbsolutePath());
        InputStream keystoreStream = new FileInputStream(keystrorefile);
        char[] passphrase="your_password".toCharArray();            

        keystore.load(keystoreStream, passphrase);
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keystore, passphrase);
        makeSSLSocketFactory(keystore, keyManagerFactory);

    } catch (KeyStoreException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (CertificateException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnrecoverableKeyException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void log(Object msj){
    System.out.println(msj.toString());
}

public void makeSSLSocketFactory(KeyStore loadedKeyStore, KeyManagerFactory key){

    try {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(loadedKeyStore);
        SSLContext ctx = SSLContext.getInstance("TLS");            
        ctx.init(key.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        SSLServerSocketFactory sslssf = ctx.getServerSocketFactory();
        ServerSocket conexion = sslssf.createServerSocket(your_port);
        SSLSocket cliente=(SSLSocket) conexion.accept();

        cliente.startHandshake();
        InputStream in = cliente.getInputStream();            
        OutputStream out = cliente.getOutputStream();
        int byte_recibido=-1;   

        while(cliente.isConnected() && (byte_recibido=in.read())>-1){
            Integer n=byte_recibido & 0xFF;  
            String s=new String(String.valueOf(Character.toChars(n)));
            log(s);
        }

            out.close();                        
            bin.close();
                    in.close();
            cliente.close();
            conexion.close();


    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (KeyStoreException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (KeyManagementException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(SServidor.class.getName()).log(Level.SEVERE, null, ex);
    }

} 

}`