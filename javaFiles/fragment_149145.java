Key pk = new Key(new AttributeValue().withN(Long.toString(123)));
AttributeValueUpdate avu = new AttributeValueUpdate(null, "DELETE");
Map<String, AttributeValueUpdate> m = new HashMap<String, AttributeValueUpdate>();
m.put(String.valueOf(555), avu);
UpdateItemRequest uir = new UpdateItemRequest("users", pk, m);
dynamoDB.updateItem(uir);