JsonNode jsonNode = objectMapper.readTree(new File("savefiles.json"));
Iterator<JsonNode> nodes = jsonNode.elements()
 while(nodes.hasNext()) {
     if(nodes.next().get("name").textValue().equals("1")){
           nodes.remove();
           }
       }