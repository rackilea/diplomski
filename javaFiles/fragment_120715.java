@Value("${useSystemProxy}")
Boolean useSystemProxy;

@Value("${proxyURL}")
String proxyURL;

@Value("${proxyPort}")
String proxyPort;

@Value("${username}")
String username;

@Value("${password}")
String password;

public void findImagesInInputStream(String url) throws IOException {

    if (useSystemProxy) {
        System.setProperty("java.net.useSystemProxies", "true");
        System.getProperties().put("http.proxyHost", proxyURL);
        System.getProperties().put("http.proxyPort", proxyPort);
        System.getProperties().put("http.proxyUser", username);
        System.getProperties().put("http.proxyPassword", password);
    }

    URL postURL = new URL(url);
    InputStream inputStream = postURL.openStream();

    findMIME(inputStream);
}