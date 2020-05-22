// Iterate over the "item" nodes of the document:
private List<MyComposite> populate(Document doc)
{
    NodeList items=doc.getElementsByTagName("item");
    List<MyComposite> list=new ArrayList<MyComposite>(items.getLength());
    for (int i = 0; i < items.getLength(); i++)
    {
        Element item = (Element)items.item(i);
        MyComposite myComposite=parseItem(item);
        list.add(myComposite);
    }
    return list;
}

// Create one MyComposite bean reading the child nodes of an input "item" node:
private MyComposite parseItem(Element item)
{
    MyComposite myComposite=new MyComposite();
    NodeList childNodes=item.getChildNodes();
    for (int i = 0; i < childNodes.getLength(); i++)
    {
        // Processing some element in the form: <name>value</name>
        Element element = (Element)childNodes.item(i);
        String nodeName = element.getNodeName();
        String nodeValue = element.getTextContent();

        // Decide where to store the node value (in myComposite) depending on the node name:
        switch (nodeName)
        {
            case "A":
                myComposite.setA(nodeValue); 
                break;
            case "B":
                myComposite.setB(nodeValue); 
                break;
            ...
            default: // An unknown node was found.
                System.err.println("Warning: Node '"+nodeName+"' not recognized and will be ignored");
        }
    }
    return myComposite;
}