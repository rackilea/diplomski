public final static void main(String[] args) throws Exception {
    URIBuilder builder = new URIBuilder();
builder.setScheme("http").setHost("api.stackexchange.com").
        setPath("/2.0/search").
        setParameter("site", "stackoverflow").
        setParameter("intitle" ,"workaround").
        setParameter("tagged","javascript");
URI uri = builder.build();
ArrayList<Question> q =null;
String result = "";
String surl = fixEncoding(uri.toString()+"&filter=!)QWRa9I-CAn0PqgUwq7)DVTM");
System.out.println(surl);
Test t = new Test();

    try {
    URL url = new URL(surl);
    q = t.readJsonStream(new GZIPInputStream(url.openStream()));        
} 

    catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println(result);

    for (Question question : q) {
        System.out.println(question.title);
    }
}