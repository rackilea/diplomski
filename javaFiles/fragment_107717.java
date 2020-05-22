class Convert {
    static DaggerAppComponent singletonProvider;
    @TypeConverter
    public static MyObject convert(String arg) {
        Gson gson = new GsonBuilder().registerTypeAdapter(MyObject.class, new MyJsonDeserializer(componentBuilder)).create();
        return gson.fromJson(arg, MyObject.class);
    }

    @TypeConverter
    public static String fromArrayLisr(MyObject object) {
        Gson gson = new Gson();
        String json = gson.toJson(v);
        return json;
    }
}