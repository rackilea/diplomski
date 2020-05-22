// In the RSS class
public String writeNews() 
{
  String result = "";
  ...
  // Instead of printing to console, store text in a String variable
  result += "Title: " + getElementValue(element,"title");
  result += "Link: " + getElementValue(element,"link");
  ...
  // Return result
  return result
}

// In the Main.news method
String rssNews = reader.writeNews();
textArea.append(rssNews);