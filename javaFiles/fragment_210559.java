String html = "<YOUR HTML HERE>";
Document doc = Jsoup.parse(html);
Elements tds = doc.select("table.hostinfo_title2").select("td");

String mp3Link = "";
for(Element td : tds) {
     if(td.text().contains("mp3") {
         mp3Link = td.text();
         // do something with mp3Link
     }
}