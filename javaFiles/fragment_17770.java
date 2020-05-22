JsonNode node = rootNode.get("A8");
        List<String>list = new ArrayList<String>();//create a ArrayList
        list.add("Anything"); //add data to arraylist 
        ArrayNode arrayNode = ((ObjectNode)node).putArray("B4"); //add the arraydata into the JSONData
        for (String item : list) { //this loop will add the arrayelements one by one.
            arrayNode.add(item);
        }