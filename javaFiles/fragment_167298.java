public static void main (String []args) throws IOException {

    Document doc = Jsoup.connect("http://www.bbc.com/earth/columns/record-breakers").get();
    Elements link = doc.select("div.promo-unit-header a");      

    for(Element e : link){
        System.out.println(e.attr("abs:href"));                    
    }       

}