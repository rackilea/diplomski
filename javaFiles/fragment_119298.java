// Deserialize to single object.
    public MyClass deserializeFromJson(String jsonString) {
        Gson gson = new Gson();
        MyClass myClass = gson.fromJson(jsonString, MyClass.class);
        return myClass;
    }