int i = 0;
int pagesNumber = 10;
String URL = "";
Document doc = null;
Elements temp = null;

try {

    // Create file 
    FileWriter fstream = new FileWriter(System.currentTimeMillis() + "out.txt");
    BufferedWriter out = new BufferedWriter(fstream);

    for (i=0; i<pagesNumber; i++) {

        URL = ("https://www.ufc.com/athletes/all?gender=All&search=&page="+i);
        doc = Jsoup.connect(URL).userAgent("mozilla/70.0.1").get();
        temp = doc.select("div.c-listing-athlete__text");

        for (Element fighter : temp) {
            out.write(i + " " + fighter.getElementsByClass("c-listing-athlete__name").first().text());
        }
    }

    //Close the output stream
    out.close();

} catch (Exception e) { // Catch exception if any
    System.err.println("Error: " + e.getMessage());
}