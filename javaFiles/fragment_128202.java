public class Main {

    static class Product {}
    static class SubProd extends Product {}
    static class Vendor<T extends Product> {}

    public static <T extends Product> Vendor<T> getInstance(Class<T> clazz) {
        return new Vendor<T>();
    }

    public static void main(String[] args) {
        Vendor<SubProd> v = Main.getInstance(Main.SubProd.class);
        System.out.println(v);
    }
}