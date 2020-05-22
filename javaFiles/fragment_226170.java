class MyJSONObj{
    private double id;
    private double number;
    private List<MyArgJson> arg;
    // getter & setter
}

class MyArgJson{
    private double id;
    private String type;
    private double beg;
    // getter & setter
}

Type type = new TypeToken<ArrayList<ArrayList<ArrayList<MyJSONObj>>>>() {}.getType();
ArrayList<ArrayList<ArrayList<MyJSONObj>>> data = gson.fromJson(json, type);
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(data));