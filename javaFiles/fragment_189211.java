public ArrayList<String> initializeMangaNameList(){
    Document doc;
    try {
        doc = Jsoup.connect("http://www.mangahere.com/mangalist/").maxBodySize(0).get();
        Elements items = doc.getElementsByClass("manga_info");
        ArrayList<String> names = new ArrayList<String>();
        for(Element item: items){
            names.add(item.text());
        }
        return names;
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;