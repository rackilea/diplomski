org.jsoup.nodes.Document doc = null;
String title = "";

System.out.println("Getting content... ");

CloseableHttpClient httpclient = HttpClients.createDefault();
HttpHost target = new HttpHost(host);
HttpGet httpget = new HttpGet(path);
CloseableHttpResponse response = httpclient.execute(target, httpget);

System.out.println("Parsing content... ");

try {
    String line = null;
    StringBuffer tmp = new StringBuffer();
    BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    while ((line = in.readLine()) != null) {                    
        String decoded = new String(line.getBytes(), "UTF-8");
        tmp.append(" ").append(decoded);
    }

    doc = Jsoup.parse(String.valueOf(tmp)); 

    title = doc.title();
    System.out.println("Title=" + title); //<== ^_^

    //[...]

} finally {
    response.close();
}

System.out.println("Done.");