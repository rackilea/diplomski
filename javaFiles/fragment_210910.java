String url = "http://en.wikipedia.org/wiki/Data_scraping#Screen_scraping";  

// Download the HTML and store in a Document
Document doc = Jsoup.connect(url).get();

// Select the <p> Elements from the document    
Elements paragraphs = doc.select("p");

// For each selected <p> element, print out its text
for (Element e : paragraphs) {
    System.out.println(e.text());
}