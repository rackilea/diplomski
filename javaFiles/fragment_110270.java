public SourceCode(URL pageURL) throws IOException {
    this.source = getSource(pageURL);
}

public String getSource() {
    return source;
}

private String getSource(URL url) throws IOException {
    URLConnection spoof = url.openConnection();
    StringBuffer sb = new StringBuffer();

    spoof.setRequestProperty("User-Agent",
            "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)");
    BufferedReader in = new BufferedReader(new InputStreamReader(
            spoof.getInputStream()));

    String strLine = "";
    while ((strLine = in.readLine()) != null) {
        sb.append(strLine);
    }

    return sb.toString();
}

public static void main(String[] args) throws IOException {
    SourceCode s = new SourceCode(new URL("https://www.google.co.in/"));
    System.out.println(s.getSource());
}