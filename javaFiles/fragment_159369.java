final ObjectMapper objectMapper = new ObjectMapper();

List<Map<String, Object>> list = rdd
        .map(new org.apache.spark.api.java.function.Function<String, Map<String, Object>>() {
            @Override
            public Map<String, Object> call(String line) throws Exception {
                TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
                };
                Map<String, Object> rs = objectMapper.readValue(line, typeRef);
                return rs;
            }
        }).collect();