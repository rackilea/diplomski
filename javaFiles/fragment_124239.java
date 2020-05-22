String url = "http://server/pages/document.htlm";
String text = "<img src = '../images/image_name1.jpg'/><img src = '../images/image_name2.jpg'/>'";
Document doc = Jsoup.parse(text, url);
Elements images = doc.getElementsByTag("img");
for (Element image : images){
    System.out.println(image.attr("src")+" -> "+image.attr("abs:src"));
}