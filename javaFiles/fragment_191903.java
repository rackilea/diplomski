class MyClass {
    private static int count = 0;
    public MyClass() {
        count++;
    }
    public static int getCount() {
        return count;
    }
}