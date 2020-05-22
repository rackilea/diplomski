Type type = new TypeToken<List<MyClass>>() {}.getType();
List<MyClass> myObjects = getMyObjects(new JsonParser().parse(json).getAsJsonObject().get("foos"), type);

public static List<T> getMyObjects(String jsonString, Type type) {
    Gson gson = new Gson();
    List<T> myList = gson.fromJson(jsonString, type);

    return myList;
}