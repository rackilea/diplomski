public static int testFinnalyBlock() throws Exception {
    int a = 5, b = 10;
    int sum = 0;
    try {
        sum = a + b;
        System.out.println("sum===" + sum);
    } catch (Exception e) {
        System.out.println("In Catch");
    } finally {
        sum = a + 30;
        System.out.println("sum===" + sum);
    }
    return sum;
}