List<String> paragraphs = getParagraphs(entity.getFile());
List<TagNode> pNodes = new ArrayList<TagNode>();

TagNode html = new TagNode("html");
for(String paragraph : paragraphs) {                
    TagNode p = new TagNode("p");
    p.addChild(new ContentNode(paragraph));
    pNodes.add(p);
}
html.addChildren(pNodes);