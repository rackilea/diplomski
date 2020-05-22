public class FbLogin {
private List<String> cookies;


private HttpURLConnection conn;

private final String USER_AGENT = "Mozilla/5.0";
private final String PROXY_HOST = "XXXXXXX";
private final String PROXY_PORT = "80";
private final String charset = "UTF-8";
private final String REDIRECT_URI = "http://localhost:8000/";
boolean redirect = false;

private void setProxy(){
    System.setProperty("http.proxyHost", PROXY_HOST);
    System.setProperty("http.proxyPort", PROXY_PORT);
    System.setProperty("https.proxyHost", PROXY_HOST);
    System.setProperty("https.proxyPort", PROXY_PORT);
}
public List<String> getCookies() {
    return cookies;
}

public void setCookies(List<String> cookies) {
    this.cookies = cookies;
}




public static void main(String[] args) {
    String USERNAME = "XXXXX@gmail.com";
    String PASSWORD = "XXXXXX";

    FbLogin httpd = new FbLogin();
    httpd.setProxy();
    // make sure cookies is turn on
    CookieHandler.setDefault(new CookieManager());
    String page = "";
    try {
        page = httpd.sendGet();

    } catch (Exception e) {

        e.printStackTrace();
    } 

    String postParams = "";
    try {
        postParams = httpd.getFormsParams(page, USERNAME, PASSWORD);
    } catch (UnsupportedEncodingException e) {

        e.printStackTrace();
    }

    try {
        httpd.sendPost(postParams);
    } catch (Exception e) {

        e.printStackTrace();
    }

}

private String sendGet()  {

    //Generating map for url path and query

    String loginUrl = "http://www.facebook.com/v1.0/dialog/oauth";
    LinkedHashMap<String, String> queryMap = new LinkedHashMap<String, String>();
    queryMap.put("redirect_uri", REDIRECT_URI);
    queryMap.put("scope", "read_stream");
    queryMap.put("client_id", "XXXXXXXXX");
    queryMap.put("ret", "login");

    //Creating URL with urlencoder
    String fbUrlString = generateUrl(loginUrl, queryMap);

    System.out.println("Generated Url ---> " + fbUrlString);
    URL myFbURL = null;
    try {
        myFbURL = new URL(fbUrlString);
    } catch (MalformedURLException e) {

        e.printStackTrace();
    }

    try {
        conn = (HttpURLConnection) myFbURL.openConnection();
    } catch (IOException e) {

        e.printStackTrace();
    }
    //optional -default is GET
    try {
        conn.setRequestMethod("GET");
    } catch (ProtocolException e) {

        e.printStackTrace();
    }

    //add request headers
    conn.addRequestProperty("User-Agent", "Mozilla");
    conn.setRequestProperty("Accept-Charset", charset);
    conn.setRequestProperty("Accept",
            "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

    //Normally 3xx response code is for redirect
    int responseCode = 0;
    try {
        responseCode = conn.getResponseCode();
    } catch (IOException e) {

        e.printStackTrace();
    }
    System.out.println( "Sending GET request to URL " + myFbURL);
    System.out.println( "Resonse code = " + responseCode);
    checkForRedirect(responseCode);
    return readPage();
}

private void sendPost(String postParams) throws Exception {

    String Url = "https://www.facebook.com/login.php";
    LinkedHashMap<String, String> queryMap = new LinkedHashMap<String, String>();
    queryMap.put("login_attempt", "1");
    queryMap.put("next", "https://www.facebook.com/v1.0/dialog/oauth?redirect_uri=http%3A%2F%2Flocalhost%3A8000%2F&scope=read_stream&client_id=XXXXXXXX&ret=login");
    //Creating URL with urlencoder
    String postUrl = generateUrl(Url, queryMap);
    System.out.println( "Generated Url ---> " + postUrl);

    URL obj = new URL(postUrl);
    conn = (HttpURLConnection) obj.openConnection();

    // Acts like a browser
    conn.setUseCaches(false);
    conn.setRequestMethod("POST");

    conn.setRequestProperty("User-Agent", USER_AGENT);
    conn.setRequestProperty("Accept",
            "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    //         for (String cookie : this.cookies) {
    //             conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
    //         }
    conn.setRequestProperty("Connection", "keep-alive");

    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

    conn.setDoOutput(true);
    conn.setDoInput(true);

    // Send post request
    DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
    wr.writeBytes(postParams);
    wr.flush();
    wr.close();

    int responseCode = conn.getResponseCode();
    System.out.println("\nSending 'POST' request to URL : " + postUrl);
    System.out.println("Post parameters : " + postParams);
    System.out.println("Response Code : " + responseCode);
    checkForRedirect(responseCode);
    readPage();
}

private String getFormsParams(String html, String username, String password)
throws UnsupportedEncodingException {

    System.out.println( "Extracting forms data");

    Document doc = Jsoup.parse(html);

    //Facebook form
    Element loginForm = doc.getElementById("login_form");
    Elements inputElements = loginForm.getElementsByTag("input");
    List<String> paramList = new ArrayList<String>();
    for(Element inputElement : inputElements ) {
        String key = inputElement.attr("name");
        String value = inputElement.attr("value");
        System.out.println("key --> " + key);
        System.out.println("value --> " + value);

        if (key.equalsIgnoreCase("email")){
            value = username;
        }
        else if(key.equalsIgnoreCase("pass")){
            value = password;
        }
        paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
    }

    //build parameter list
    StringBuilder result = new StringBuilder();
    for(String param : paramList) {
        if(result.length() == 0){
            result.append(param);
        } else {
            result.append("&" + param);
        }
    }
    return result.toString();
}

private String readPage(){
    BufferedReader buffReader = null;
    try {
        buffReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    } catch (IOException e) {

        e.printStackTrace();
    }
    String inputLine;
    StringBuffer response = new StringBuffer();

    try {
        while ((inputLine = buffReader.readLine()) != null) {
            response.append(inputLine);
        }
    } catch (IOException e) {

        e.printStackTrace();
    }
    try {
        buffReader.close();
    } catch (IOException e) {

        e.printStackTrace();
    }

    return response.toString();
}
private void redirectHandler(){
    //If redirect is true launch the new redirected url
    if(redirect) {
        // get redirect url from "location" header field
        String newURL = conn.getHeaderField("Location");

        // get the cookie if need, for login
        String cookies = conn.getHeaderField("Set-Cookie");

        try {
            conn = (HttpURLConnection) new URL(newURL).openConnection();
        } catch (IOException e) {

            e.printStackTrace();
        }
        //          conn.setRequestProperty("Cookie", cookies)
        conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
        conn.addRequestProperty("User-Agent", "Mozilla");


        System.out.println( "Redirecting to " + conn.getURL());
        try {
            System.out.println( "Resonse code = " + conn.getResponseCode());
        } catch (IOException e) {

            e.printStackTrace();
        }
        try {
            checkForRedirect(conn.getResponseCode());
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
private void checkForRedirect(int responseCode){
    if(responseCode != HttpURLConnection.HTTP_OK) {
        if(responseCode == HttpURLConnection.HTTP_MOVED_TEMP
        || responseCode == HttpURLConnection.HTTP_MOVED_PERM
        || responseCode == HttpURLConnection.HTTP_SEE_OTHER) {
            redirect = true;
            redirectHandler();
        }
    }
}


private String generateUrl(String url, LinkedHashMap<String, String> queryMap) {
    System.out.println( "Inside generateUrl method ...");
    StringBuilder query = new StringBuilder();
    char separator = '?';

    for(Entry<String, String> entry : queryMap.entrySet()) {
        query.append(separator);
        separator = '&'     ;   
        try {
            query.append(URLEncoder.encode(entry.getKey(), charset));
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        query.append("=");
        try {
            query.append(URLEncoder.encode(entry.getValue(), charset));
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
    }
    url = url + query;
    return url;
}

}