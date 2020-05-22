ObjectMapper mapper = new ObjectMapper();

JsonNode json1 = mapper.readTree(json_string_1);
JsonNode json2 = mapper.readTree(json_string_2);

assertEquals(json1, json2);