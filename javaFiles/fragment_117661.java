class MyPOJO {
    private String one;
    private String two;
    private String three;
    // getter & setter
}

String jsonString = "[{\"one\":\"1\",\"two\":\"2\",\"three\":\"3\"}, {\"one\":\"4\",\"two\":\"5\",\"three\":\"6\"}, {\"one\":\"7\",\"two\":\"8\",\"three\":\"9\"}]";
Type type = new TypeToken<ArrayList<MyPOJO>>() {}.getType();
ArrayList<MyPOJO> obj = new Gson().fromJson(jsonString, type);
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(obj));