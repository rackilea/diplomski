Document doc = Jsoup.parse(html);
    Elements options=doc.select("select[id=secondary_contact_type] > option");
    for(Element data:options){
        System.out.println(data.attr("value"));
        System.out.println(data.ownText());
    }