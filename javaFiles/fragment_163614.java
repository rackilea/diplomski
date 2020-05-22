public String convert(Map<String, ? extends Metadata> metadataMap) {
        String output = "";
        Map<String, List<Map<String, String>>> finalMap = new HashMap<>();
        metadataMap.forEach((k, v) -> {

            List<Map<String, String>> datamap = new LinkedList<>();

            String key = k;
            String[] fields = v.getFields();
            List<String> lines = v.getLines();


            lines.forEach(line -> {
                if (line != null && !line.isEmpty() && !line.equals("null")) {
                    String[] fieldData = line.split("\t",-1);
                    Map<String, String> eachLineMap = new HashMap<>();
                    for (int index = 0; index < fields.length; index++) {
                        if (index < fieldData.length && (fieldData[index] != null && !fieldData[index].isEmpty())) {
                            eachLineMap.put(fields[index], fieldData[index]);
                        } else {
                            eachLineMap.put(fields[index], " ");
                        }
                        datamap.add(eachLineMap);
                    }
                }
            });
            finalMap.put(key, datamap);
        });

        try {
            output = new ObjectMapper().writeValueAsString(finalMap);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }

        return output;
    }