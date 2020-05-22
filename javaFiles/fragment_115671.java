text = builder.toString();
ObjectMapper mapper = new ObjectMapper();
Map<String, Object> map = mapper.readValue(text, new TypeReference<Map<String, Object>>() {
});

List mainMap2 = (List) map.get("weather");
//for (Object item : mainMap2) {
//    System.out.println("itemResult" + item.toString());
//}
int id = (int)((Map)mainMap2.get(0)).get("id");
System.out.println(id);