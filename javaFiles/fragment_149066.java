NodeList pnodes = doc.getElementsByTagName("p");
        for(int i=0;i<pnodes.getLength();i++){
            NodeList nodes = pnodes.item(i).getChildNodes();
            int k = 0;
            for(int j = 0;j<nodes.getLength();j++){
                if(nodes.item(j).getNodeName().equals("#text")){////Check if the current child element is a text node or not, if yes then replace it with the new P element
                    k++;
                    Element title = doc.createElement("P");
                     title.appendChild(doc.createTextNode(nodes.item(j).getNodeValue()));
                     String tempId = Id + k; // generate the new Id
                     title.setAttribute("id",tempId);
                     pnodes.item(i).replaceChild(title, nodes.item(j)); // replace the child element, instead of appending
                }
            }