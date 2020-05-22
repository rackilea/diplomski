List children = rootNode.getChildren();

for (int i = 0; i < list.size(); i++) {

    Element node = (Element) list.get(i);

    List dataNodes = node.getChildren();

    for (int j = 0; j < dataNodes.size(); ++j) {

        Element dataNode = (Element) dataNodes.get(j);
        System.out.println(dataNode.getName() + " : " + dataNode.getText());

    }

}