private boolean proxyEnabled = true;

public static void main(String[] args) throws Exception {
    URL oracle = new URL("http://finance.yahoo.com/d/quotes.csv?s=XOM+EK+JNJ+MSFT&f=snd1t1l1ohgvwdyr");
    URLConnection yc;
    if(proxyEnabled) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("my.proxy.example.com", 3128));
        yc = oracle.openConnection(proxy);
    } else {
        yc = oracle.openConnection();
    }
    BufferedReader in = new BufferedReader(new InputStreamReader(
        yc.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null)

        System.out.println(inputLine);
    in.close();
}