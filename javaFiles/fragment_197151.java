for (int i = 0; i < nList.getLength(); i++)
{
      Node node = nList.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE)
      {                 
             if(eElement.hasChildNodes())
             {
                 NodeList nl = node.getChildNodes();
                 for(int j=0; j<nl.getLength(); j++)
                 {
                     Node nd = nl.item(j);
                     System.out.println(nd.getTextContent());
                 }
             }
       }
}