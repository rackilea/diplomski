Elements brackets = doc.getElementsByTag("bracket");
for (Element bracket : brackets) {
    Element lis = bracket.select("li");
    Element name = bracket.previousElementSibling();
    System.out.println(name.text());
    for (Element li : lis){
      System.out.println(li.text());
    }       
}