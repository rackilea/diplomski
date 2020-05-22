NodeList nm = docElement.getElementsByTagName("Name");
                if (nm.getLength() > 0) {
                    Node n = nm.item(0);
                    Node child = n.getFirstChild();
                    if(child == null) {
                        // null handling
                        name = null;
                     }
                    else {
                       name = nullIfBlank(child.getTextContent());
                    }

                 }