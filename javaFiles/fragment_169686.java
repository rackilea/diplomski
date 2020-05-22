public static void main(String[] args) {
    try {
        java.net.URL connection_url = new java.net.URL("http://:/path");
        System.out.println("Instantiated new URL: " + connection_url);
    }
    catch (MalformedURLException e) {
        e.printStackTrace();
    }
}