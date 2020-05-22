URL url = 
new URL( "http://pasca.undiksha.ac.id/e-journal/index.php/jurnal_bahasa/article/view/500" );

URLConnection connection = url.openConnection();

input = connection.getInputStream();

Document doc = Jsoup.parse(in, "UTF-8");
System.out.println(doc.toString());