// Serialize a single object.    
    public String serializeToJson(MyClass myClass) {
        Gson gson = new Gson();
        String j = gson.toJson(myClass);
        return j;
    }