NodeList nodes = getParents(getTestingResponse(), targetNodeName);
    HashMap<Integer, Object> hm = new HashMap<Integer, Object>();
    for (int i = 0 ; i < nodes.getLength() ; i++){
        Element currentElement = (Element) nodes.item(i);
        NodeList fields = currentElement.getChildNodes();               
        for (int j = 0 ; j < fields.getLength() ; j++){
            Node currentFieldElement = fields.item(j);
            List<Integer> integer = new ArrayList<Integer>();
            List<Integer> integerNew = new ArrayList<Integer>();
            if (currentFieldElement != null && currentFieldElement.getNodeType() == Node.ELEMENT_NODE) {
                String key =  currentFieldElement.getNodeName();
                String[] value = currentFieldElement.getTextContent().split("\n");

                for (String v : value) {
                    System.out.println(v);
                    try {
                        integer.add(Integer.parseInt(v.trim()));
                    } catch(Exception e) {}                     
                }

                integerNew.add(integer.get(1));
                integerNew.add(integer.get(2));
                integerNew.add(integer.get(3));
                hm.put(integer.get(0), integerNew);
            }
        }
    }
    System.out.println(hm);