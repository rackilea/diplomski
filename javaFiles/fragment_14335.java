public static List<String> getAuthors(Document doc) throws Exception {
    List<String> authors = new ArrayList<String>();
    NodeList authorNodes = doc.getElementsByTagName("author");
    for (int i = 0; i < authorNodes.getLength(); i++) {
        String author = authorNodes.item(i).getTextContent();
        Bukkit.getServer().broadcastMessage("here");
        authors.add(author);
    }
    return authors;
}