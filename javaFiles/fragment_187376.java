public static void f(int a, int b) {
    if (a == b) {
        System.out.print(a);
    }
    else {
        System.out.print(a + ",");
        f(a+1,b);
        System.out.print("," + a);
    }
}