ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.readEntity(String.class));
        JsonNode rowsNode = rootNode.path("rows");
        Iterator<JsonNode> elements = rowsNode.elements();
        while (elements.hasNext()){
            JsonNode columnNodes = elements.next();
            System.out.println("All the Column Values: " + columnNodes.asText());
            Map<String, Object> values = new HashMap<String, Object>();
            values = mapper.treeToValue(columnNodes, HashMap.class);
            ERow row = new ERow();
            row.setColumn(values);
            columns.add(row);
        }
        result.setRows(columns);