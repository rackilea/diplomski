Document doc = Jsoup.connect(/*URL of your HTML document*/").get();
Element part = doc.body();
Elements parts = part.getElementsByTag("div");
String attValue;
String requiredContent;
for(Element ent : parts)
{
    if(ent.hasAttr("class"))
    {
        attValue = ent.attr("class");
        if(attValue.equals("g-b bidsold"))
        {
            System.out.println("\n");
            requiredContent=ent.text();
            System.out.println(requiredContent);
        }
    }
}