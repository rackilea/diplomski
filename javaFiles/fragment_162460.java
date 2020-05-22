public class Main {

    public class Base {
        @Expose
        @SerializedName("class")
        protected String clazz = getClass().getSimpleName();
        protected String control = "ctrl";
    }

    public class Child extends Base {
        protected String text = "This is text";
        protected Boolean boolTest = false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Main m = new Main();
        GsonBuilder b = new GsonBuilder();
        BooleanSerializer serializer = new BooleanSerializer();
        b.registerTypeAdapter(Boolean.class, serializer);
        b.registerTypeAdapter(boolean.class, serializer);
        Gson gson = b.create();

        Child c = m.new Child();
        System.out.println(gson.toJson(c));
        String testStr = "{\"text\":\"This is text\",\"boolTest\":1,\"class\":\"Child\",\"control\":\"ctrl\"}";
        Child cc = gson.fromJson(testStr, Main.Child.class);
        System.out.println(gson.toJson(cc));
    }
}