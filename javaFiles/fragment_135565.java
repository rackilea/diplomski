Document doc = null;
         NodeList list = doc.getElementsByTagName("Veriler");
         Node node = list.item(0);
         Element element = (Element) node;
         NodeList nl = element.getChildNodes();
         for (int i = 0; i < nl.getLength(); i++){
             ((Element) nl.item(i)).getAttribute("GUNLUKYUKSEK");
         }