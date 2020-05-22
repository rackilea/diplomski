public static void main(String[] args) {
    String xml = "<DOC><DOCNO>annotations/01/1001.eng</DOCNO><TITLE>Godchild Gustavo Javier Cuchiparte Umaginga</TITLE><DESCRIPTION>a dark-skinned boy wearing a black cap;</DESCRIPTION><NOTES></NOTES><LOCATION>Quilotoa,Ecuador</LOCATION><DATE>April 2002</DATE><IMAGE>images/01/1001.jpg</IMAGE><THUMBNAIL>thumbnails/01/1001.jpg</THUMBNAIL></DOC>";
    Document doc = Jsoup.parse(xml,"",Parser.xmlParser());
    String image = doc.select("IMAGE").first().text();
    String image2 = doc.getElementsByTag("IMAGE").get(0).text();
    System.out.println(image);
    System.out.println(image2);
}