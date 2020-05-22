Document doc = null;
try {
    doc = Jsoup.connect("http://en.wikipedia.org/wiki/List_of_bow_tie_wearers").get();
} catch (IOException e) {

}

if (doc != null) {

    // The Architect headline has an id. Awesome! Let's select it.
    Element architectsHeadline = doc.select("#Architects").first();

    // For educational purposes, let's see what we've got there...
    System.out.println(architectsHeadline.html());

    // Now, we use some other selector then .first(), since we need to
    // get the tag after the h3 with id Architects.
    // We jump back to the h3 using .parent() and select the succeding tag
    Element architectsList = architectsHeadline.parent().nextElementSibling();

    // Again, let's have a peek
    System.out.println(architectsList.html());

    // Ok, now since we have our list, let's traverse it.
    // For this we select every a tag inside each li tag
    // via a css selector
    for(Element e : architectsList.select("li > a")){
      System.out.println(e.text());
    }
}