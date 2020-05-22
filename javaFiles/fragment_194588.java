Element genre = rootNode.getChild("Genre");

Iterator<Element> names = genre.getChildren("Name").iterator();
while (names.hasNext()) {
     String name = names.next().getText();
     ...
}