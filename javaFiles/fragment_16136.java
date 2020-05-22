//Get the HTML
Document doc = Jsoup.parse(html); 
//or
Document doc = Jsoup.connect(url).get();

//Select the elements
Elements col2Elements = doc.select("div.col2"); //This will return a collection of Element objects
String firstElement = col2Elements.get(0).text(); //Get the first
String secondElement = col2Elements.get(1).text(); //Get the second