import java.io.*;
import java.security.KeyStore;

import javax.net.ssl.*;

import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.*;
import org.apache.http.conn.scheme.*;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.*;

import android.app.Activity;
import android.os.Bundle;

public class SslTestActivity extends Activity {

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    try {
      // setup truststore to provide trust for the server certificate

      // load truststore certificate
      InputStream clientTruststoreIs = getResources().openRawResource(R.raw.truststore);
      KeyStore trustStore = null;
      trustStore = KeyStore.getInstance("BKS");
      trustStore.load(clientTruststoreIs, "MyPassword".toCharArray());

      System.out.println("Loaded server certificates: " + trustStore.size());

      // initialize trust manager factory with the read truststore
      TrustManagerFactory trustManagerFactory = null;
      trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init(trustStore);

      // setup client certificate

      // load client certificate
      InputStream keyStoreStream = getResources().openRawResource(R.raw.client);
      KeyStore keyStore = null;
      keyStore = KeyStore.getInstance("BKS");
      keyStore.load(keyStoreStream, "MyPassword".toCharArray());

      System.out.println("Loaded client certificates: " + keyStore.size());

      // initialize key manager factory with the read client certificate
      KeyManagerFactory keyManagerFactory = null;
      keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      keyManagerFactory.init(keyStore, "MyPassword".toCharArray());


      // initialize SSLSocketFactory to use the certificates
      SSLSocketFactory socketFactory = null;
      socketFactory = new SSLSocketFactory(SSLSocketFactory.TLS, keyStore, "MyTestPassword2010",
          trustStore, null, null);

      // Set basic data
      HttpParams params = new BasicHttpParams();
      HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(params, "UTF-8");
      HttpProtocolParams.setUseExpectContinue(params, true);
      HttpProtocolParams.setUserAgent(params, "Android app/1.0.0");

      // Make pool
      ConnPerRoute connPerRoute = new ConnPerRouteBean(12);
      ConnManagerParams.setMaxConnectionsPerRoute(params, connPerRoute);
      ConnManagerParams.setMaxTotalConnections(params, 20);

      // Set timeout
      HttpConnectionParams.setStaleCheckingEnabled(params, false);
      HttpConnectionParams.setConnectionTimeout(params, 20 * 1000);
      HttpConnectionParams.setSoTimeout(params, 20 * 1000);
      HttpConnectionParams.setSocketBufferSize(params, 8192);

      // Some client params
      HttpClientParams.setRedirecting(params, false);

      // Register http/s shemas!
      SchemeRegistry schReg = new SchemeRegistry();
      schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      schReg.register(new Scheme("https", socketFactory, 443));
      ClientConnectionManager conMgr = new ThreadSafeClientConnManager(params, schReg);
      DefaultHttpClient sClient = new DefaultHttpClient(conMgr, params);

      HttpGet httpGet = new HttpGet("https://server/path/service.wsdl");
      HttpResponse response = sClient.execute(httpGet);
      HttpEntity httpEntity = response.getEntity();

      InputStream is = httpEntity.getContent();
      BufferedReader read = new BufferedReader(new InputStreamReader(is));
      String query = null;
      while ((query = read.readLine()) != null)
        System.out.println(query);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}