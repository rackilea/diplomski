public class Human {
    // in Human.java
    public static class Charlie extends Human {
        public static  int number = 0;
    }

    public static void main(String[] argv) {
         System.out.println(new Human.Charlie().number);
    }
}