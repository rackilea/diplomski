import java.io.UnsupportedEncodingException;
import java.net.*;

public static String getEncodedURL(String urlString) {
    final String encodedURL;
    try {
        String decodedURL = URLDecoder.decode(urlString, "UTF-8");
        URL url = new URL(decodedURL);
        URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        final URL urlFromDecoding = uri.toURL();
        encodedURL = URLEncoder.encode(urlFromDecoding.toString(), "UTF-8");
    } catch (UnsupportedEncodingException e) {
        ...
    } catch (MalformedURLException e) {
        ...
    } catch (URISyntaxException e) {
        ...
    }
    return encodedURL;
}