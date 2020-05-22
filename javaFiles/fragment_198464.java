Gson gson = new Gson();
JsonPojo[] array = gson.fromJson(json, JsonPojo[].class);
for (JsonPojo obj : array) {
    System.out.println("id: " + obj.getId());
    // etc
}