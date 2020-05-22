ObjectMapper mapper = new ObjectMapper();
JsonNode node = mapper.readTree(source);

List<JsonNode> prices = node.findValues("price");
for (JsonNode price : prices) {
    System.out.println(price.get("total"));
    System.out.println(price.get("totalTaxes"));
}