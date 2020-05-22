ManagedObjectRepresentation singleConfig;

Map<String, Object> attrs = singleConfig.getAttrs();
ObjectMapper mapper = new ObjectMapper();
JsonNode jsonNode = mapper.valueToTree(attrs);

String customFieldName = jsonNode.get("c8y_PropertyType").get("attrs").iterator().next().get("sap_field_name").get("adressIdentifier").asText();