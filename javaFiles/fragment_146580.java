//check if there is any optional childnode
          if(cur.hasChildNodes()) {
            NodeList stChildNodes = cur.getChildNodes();
             // Loop through all the nodes and find the club node only
            for(Node child : stChildNodes) {
              if(child.getNodeName().equals("club") {
                  //"club" node detected. now loop through the attributes like the way you already did for students
                  NamedNodeMap clubAttr = child.getAttributes();
                  for(int j=0; j<clubAttr.getLength(); j++){
                    Node clattr = clubAttr.item(j);
                    if(clattr.getNodeName().equals("name")) {
                      clubname = clattr.getNodeValue();
                    }
                  }
                  break; // probably we are not interested in other nodes
               }
             }
          }