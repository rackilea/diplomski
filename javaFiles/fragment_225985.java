class Test5A {
    private int value;

    public void instanceMethod() {
        Test5A a = new Test5A() {{ value = 1; }}; // (A)
        System.out.println(this.value);
        System.out.println(a.value);
    }

    public static void main(String[] args) {
        new Test5A().instanceMethod();
    }
}