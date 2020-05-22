ArrayList<Url> urls=new ArrayList<Url>();
Document doc=Jsoup.parse(contentString);
Elements els=doc.select("a[href]");
for(Element el : els)
    if(el.attr("rel").equals("prettyPhoto[gallery-113]"))
       urls.add(new Url(el.attr("href")));