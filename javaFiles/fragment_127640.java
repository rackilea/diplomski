NodeList nodeList = document.getElementsByTagName("*");
for (int i = 0; i < nodeList.getLength(); i++)
    {
    Node node = nodeList.item(i);
    if (node.getNodeType() == Node.ELEMENT_NODE)
        {
        Element element=(Element) node;

        System.out.print(element.getNodeName()+" = ");
        boolean is_first_child=true;

        // CHILDS
        NodeList nodechilds=node.getChildNodes();

        for (int j = 0; j < nodechilds.getLength(); j++)
            {
            Node a_child = nodechilds.item(j);

            if (a_child.getNodeType() == Node.ELEMENT_NODE)
                {
                if (!is_first_child) System.out.print (",");
                System.out.print (a_child.getNodeName());

                is_first_child=false;
                }
            }

    if (is_first_child) System.out.print ("null");
    System.out.println();
    }
}