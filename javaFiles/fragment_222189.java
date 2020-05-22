// Load and parse the document fragment.
File f = new File("myfile.html"); // See also Jsoup#parseBodyFragment(s)
Document doc = Jsoup.parse(f, "UTF-8", "http://example.com");

// Remove all script and style elements and those of class "hidden".
doc.select("script, style, .hidden").remove();

// Remove all style and event-handler attributes from all elements.
Elements all = doc.select("*");
for (Element el : all) { 
  for (Attribute attr : el.attributes()) { 
    String attrKey = attr.getKey();
    if (attrKey.equals("style") || attrKey.startsWith("on")) { 
      el.removeAttr(attrKey);
    } 
  }
}
// See also - doc.select("*").removeAttr("style");