public class GsonClassNameTest {
    static Gson create = new GsonBuilder().registerTypeAdapterFactory(RuntimeClassNameTypeAdapterFactory.of(Object.class)).create();
    public static void main(String[] args) {
        String json = create.toJson(new X());
        System.out.println(json);
    }
    public static class X {
        public String test = "asd";
        public int xyz = 23;
        public Y y_class = new Y();
    }
    public static class Y {
        String yTest = "asd2";

        Z zTest = new Z();
    }
    public static class Z {
        long longVal = 25;
        double doubleTest = 2.4;
    }
}