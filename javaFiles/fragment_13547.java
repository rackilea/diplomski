String url="http://www.cpsc.gov/en/Recalls/2004/CPSC-NETGEAR-Inc-Announce-Recall-of-Wall-Plug-Ethernet-Bridges-/";

Document doc = Jsoup.connect(url).get();

Elements archived = doc.select("div.archived strong");

for (Element element: archived){
    System.out.println("KEY: " + element.text());
    System.out.println("VALUE: " + element.nextSibling());
}