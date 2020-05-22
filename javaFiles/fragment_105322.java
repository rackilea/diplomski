public static void main(String args[]) {
    JacksonTester tester = new JacksonTester();
    try {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = IN_JSON;

        @SuppressWarnings("unchecked")
        Map<String, Object> rootNode = mapper.readValue(jsonString, Map.class);

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> inputElemnts = 
            (ArrayList<Map<String, Object>>) rootNode.getOrDefault("InputJson", null);
        List<OutputElement> outputElements = new ArrayList<>();

        for (Map inputElemnt : inputElemnts) {
            String fullpath = (String) inputElemnt.get("Dir");
            String[] tree = fullpath.substring(1).split("/");
            final int deepth = tree.length;
            String dirName = tree[deepth - 1];

            final String value = (String) inputElemnt.get("name");
            final String id = (String) inputElemnt.get("id");
            String type = (String) inputElemnt.get("type");                
            OutputElement outputElement;

            if (type != null && type.equals("dir")) {
                outputElement = new OutputDir();
            } else {
                if(type==null) type = "file";
                outputElement = new OutputElement();
            }

            outputElement.setValue(value);
            outputElement.setId(id);
            outputElement.setType(type);

            if (!contains(outputElements, value)) {
                outputElements.add(outputElement);
            }

            if (deepth > 1) {
                String parentName = tree[deepth - 2];

                for (OutputElement element : outputElements) {
                    if (element.getValue().equals(parentName)) {
                        element.addOutData(outputElement);
                    }
                }
            }

//            for (int i = 0; i < deepth -1; i++) {
//                System.out.println(tree[i]);
//            }
        }
        OutputElement routOutputs = outputElements.get(0);
        String outputJson = mapper.writerWithDefaultPrettyPrinter()
                                  .writeValueAsString(routOutputs);

        System.out.println(outputJson);

    } catch (JsonParseException | JsonMappingException e) {
    } catch (IOException e) {
    }
}