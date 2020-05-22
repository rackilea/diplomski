String url = "http://www.apkmania.co/2013/07/blood-sword-thd-v16-apk.html";
Document content = null;
try {
    content = Jsoup.connect(url).userAgent("Mozilla").timeout(10*1000).get();
} catch (final IOException e) {
    // TODO Auto-generated catch block
    System.out.println("IOException: " + e.toString()); 
}
System.out.println(content);