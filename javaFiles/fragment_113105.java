Elements a2 = doc.select("div.secondary-attributes");             
for (Element e : a2) {                                            
    if (e.select("div.secondary-attributes>address").size() > 0) {
        System.out.println("exist!");                             
    } else {                                                      
        System.out.println("nothing");                            
    }                                                             
}