Document doc = Jsoup.connect("...").get();
System.out.println("title: " + doc.title());

/* here: all <span> with class=userContent */
Elements userContents = doc.select("span.userContent"); 
for (Element span : userContents) {
    System.out.println("User Content: "+span.text());
}