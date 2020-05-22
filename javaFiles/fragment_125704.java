Map<String, Object> hashMap = new HashMap<String, Object>();
hashMap.put("data", "{\"rowNum\":0,\"colNum\":2,\"text\":\"math\"}");
ObjectMapper mapper = new ObjectMapper();
TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {};

HashMap<String, Object> o = mapper.readValue(hashMap.get("data").toString(), typeRef);