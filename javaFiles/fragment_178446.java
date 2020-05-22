String html = "<html><head></head><body><p>asdasd1</p><p>asdasd2</p></body></html>";

Document doc = Jsoup.parse(html);
Elements p = doc.select("p");

for(int i=0;i<p.size();i++){
    Log.i("p",p.get(i).text());
}