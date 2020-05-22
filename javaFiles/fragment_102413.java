public static void main(String[] args) {
        String a = "three";
        String b = "two";
        sentence(a, b, 3);
    }

    public static void sentence(String a, String b, int number) {
        String str1 = a + " times " + b + " = " + (number * 2);
        System.out.println(str1); // to let you inspect the value
    }