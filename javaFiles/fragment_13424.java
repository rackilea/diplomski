public class Splitter {

    public static void main(final String[] args) {
        final String asd = "this is test ass this is test";
        final String[] parts = asd.split("ass");
        for (final String part : parts) {
            System.out.println(part);
        }
    }
}