Parent parent = objectMapper.treeToValue(objectMapper.readTree("{\n" +
    "    \"objectType\" : \"child\",\n" +
    "    \"productType\" : \"child\",\n" +
    "    \"field1\" : \"value1\",\n" +
    "    \"field2\" : \"value2\"\n" +
    "}"), Parent.class);
System.out.println(parent.getProductType());