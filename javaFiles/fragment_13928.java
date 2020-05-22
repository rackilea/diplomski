Map<String,List<String>> categoryToArticlesMap = new HashMap<String,List<String>>();
NodeList categoryNd = doc.getElementsByTagName("Category");
for (int i = 0; i < categoryNd.getLength(); i++) 
{
    Element e = (Element) categoryNd.item(i);
    String categoryName = e.getAttribute("name"); 
    NodeList articlesNd = e.getElementsByTagName("Articles");
    Element e1 = (Element) articlesNd.item(0);
    NodeList articleNd = e1.getElementsByTagName("article");
    List<String> articles = new ArrayList<String>();
    for (int j = 0; j < articleNd.getLength(); j++) {
        Element articleNode = (Element) articleNd.item(j);
        String articleName = articleNode.getAttribute("title");
        articles.add(articleName);
    }
    categoryToArticlesMap.put(categoryName, articles);
}