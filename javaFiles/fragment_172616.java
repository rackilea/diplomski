Node grandpa = document.getElementsByTagName("textlist").item(0);
Node daddy = grandpa.getFirstChild();
while (daddy != null) {
    System.out.println(">>> " + daddy.getNodeName());
    Node child = daddy.getFirstChild();
    if (child != null)
        System.out.println(">>>>>>>> " + child.getTextContent());
    daddy = daddy.getNextSibling();
}