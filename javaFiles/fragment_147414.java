ObjectMapper mapper = new ObjectMapper();
mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

JsonNode node = //node where the value is defined as Double

Double value = null;
try {
    value = mapper.treeToValue(node, Double.class);
}
catch (IOException e) {
    e.printStackTrace();
}

System.out.println(value);