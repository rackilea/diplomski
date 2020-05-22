class YourClass {
    private int specialAdd (int a, int b) {
       if(a < 100) {
           return 100 * a + b;
       } else {
           return a + b;
    }

    public static void main(String[] args) {
        System.out.println(new YourClass().specialAdd(10, 100));
    }
}