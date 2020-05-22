class Main {
    public static void main(String args[]) {
        String p1 = "+972-54-333-55-88";
        String p2 = "+972-543335588";
        String p3 = "+972543335588";
        String p4 = "+97(2543)335588";
        String p5 = "+97 2543 335588";
        String regex = "[^0-9+]";

        System.out.println(p1.replaceAll(regex, ""));
        System.out.println(p2.replaceAll(regex, ""));
        System.out.println(p3.replaceAll(regex, ""));
        System.out.println(p4.replaceAll(regex, ""));
        System.out.println(p5.replaceAll(regex, ""));
    }
}