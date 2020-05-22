public class Example {

    public static void main(String[] args) {

        String test = "a3f6+[,b7*\"d/-8u";
        System.out.println(test.replaceAll("[^0-9/*+-]", ""));
    }
}