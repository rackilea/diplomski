ObjectMapper mapper = new ObjectMapper();
List<Employee> e = new ArrayList<Employee>();
ArrayNode array = mapper.valueToTree(e);
ObjectNode companyNode = mapper.valueToTree(company);
companyNode.putArray("Employee").addAll(array);
JsonNode result = mapper.createObjectNode().set("company", companyNode);