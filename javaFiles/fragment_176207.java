try 
      { 
        // File inputFile = new File("Input.xml");

         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

         Document doc = dBuilder.parse(DomParserPuCm.class.getResourceAsStream("Input.xml"));

         doc.getDocumentElement().normalize();

         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

         NodeList params = doc.getElementsByTagName("Params");
         HashMap<Integer, Object> paramsHM = new HashMap<Integer, Object>();
         System.out.println(params.getLength());

         for (int p = 0; p < params.getLength(); p++) {
             NodeList param = params.item(p).getChildNodes();

             if (param.item(p).getLocalName() != null) {

                 for (int z = 0; z < param.getLength(); z++) {
                     System.out.println(param.item(z).getLocalName());
                     if(param.item(z).getLocalName().equals("Param")) {
                         NodeList children = param.item(z).getChildNodes();
                         for (int c = 0; c < children.getLength(); c++) {
                             int paramID = 0;
                             int value1 = 0;
                             int value2 = 0;
                             int value3 = 0;
                             List<Integer> valueList = new ArrayList<Integer>(); 

                             if (children.item(c).getLocalName() != null) {
                                 if (children.item(c).getLocalName().equals("ParamID")) {
                                     try{paramID = Integer.parseInt(children.item(c).getFirstChild().getNodeValue());}catch(Exception e){}
                                 } else if (children.item(c).getLocalName().equals("value")) {
                                     NodeList values = children.item(c).getChildNodes();                                         
                                     try{value1 = Integer.parseInt(values.item(0).getFirstChild().getNodeValue());}catch(Exception e){}
                                     try{value2 = Integer.parseInt(values.item(1).getFirstChild().getNodeValue());}catch(Exception e){}
                                     try{value3 = Integer.parseInt(values.item(2).getFirstChild().getNodeValue());}catch(Exception e){}
                                     valueList.add(value1);
                                     valueList.add(value2);
                                     valueList.add(value3);
                                 }
                             }

                             System.out.print(valueList);
                             paramsHM.put(paramID, valueList);
                         }
                     }
                 }

             }
         }

         System.out.print(paramsHM);

      } 
      catch (Exception e) 
      {
         e.printStackTrace();
      }