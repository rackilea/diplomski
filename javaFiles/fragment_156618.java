import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

...

final HttpParams httpParams = new BasicHttpParams();

// load the keystore containing the client certificate - keystore type is probably jks or pkcs12
final KeyStore keystore = KeyStore.getInstance("pkcs12");
InputStream keystoreInput = null;
// TODO get the keystore as an InputStream from somewhere
keystore.load(keystoreInput, "keystorepassword".toCharArray());

// load the trustore, leave it null to rely on cacerts distributed with the JVM - truststore type is probably jks or pkcs12
KeyStore truststore = KeyStore.getInstance("pkcs12");
InputStream truststoreInput = null;
// TODO get the trustore as an InputStream from somewhere
truststore.load(truststoreInput, "truststorepassword".toCharArray());

final SchemeRegistry schemeRegistry = new SchemeRegistry();
schemeRegistry.register(new Scheme("https", new SSLSocketFactory(keystore, keystorePassword, truststore), 443));

final DefaultHttpClient httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);