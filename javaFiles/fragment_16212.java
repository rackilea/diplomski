String URL = "http://pastebin.com/raw/Sa2MRCTQ";
Document doc = Jsoup.connect(URL).get();
Elements trs = doc.select("tr:has(td.liste-startzeit)");
String currentDay = null;
for (Element tr : trs){
    Element tdDay = tr.select("td.liste-wochentag").first();
    if (tdDay!=null){
        currentDay = tdDay.text();
    }   
    Element tdStart = tr.select("td.liste-startzeit").first();

    System.out.println(currentDay +" : "+tdStart.text());
}