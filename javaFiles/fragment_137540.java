private class Connection extends Thread{
        Vector nodes_vect=new Vector();
        Vector elements_vect=new Vector();
        public Connection(){
            super();
        }

        public void run(){
            // define variables later used for parsing
            Document doc;
            StreamConnection conn;

            try{
                //providing the location of the XML file,
                //your address might be different
                conn=(StreamConnection)Connector.open
                  ("http://localhost:8000/content/test.xml;deviceside=true");//  http://localhost:8000/content/test.xml
                //next few lines creates variables to open a
                //stream, parse it, collect XML data and
                //extract the data which is required.
                //In this case they are elements,
                //node and the values of an element
                DocumentBuilderFactory docBuilderFactory
                  = DocumentBuilderFactory. newInstance(); 
                DocumentBuilder docBuilder
                  = docBuilderFactory.newDocumentBuilder();
                docBuilder.isValidating();
                doc = docBuilder.parse(conn.openInputStream());
                doc.getDocumentElement ().normalize ();
                NodeList list=doc.getElementsByTagName("*");
                _node=new String();
                _element = new String();
                //this "for" loop is used to parse through the
                //XML document and extract all elements and their
                //value, so they can be displayed on the device

                for (int i=0;i<list.getLength();i++){
                    Node value=list.item(i).
                      getChildNodes().item(0);
                    _node=list.item(i).getNodeName();
                    _element=value.getNodeValue();
                  nodes_vect.addElement(_node);
                  elements_vect.addElement(_element);
                   if(i==list.getLength()-1){


                       pushingToNextScreen(nodes_vect, elements_vect);//after last element it will 
                   }
                }//end for
            }//end try
            //will catch any exception thrown by the XML parser
            catch (Exception e){
                System.out.println(e.toString());
            }
        }//end connection function
    }// end connection class
}//end XML_Parsing_Sample