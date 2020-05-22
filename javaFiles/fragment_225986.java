class Test5B {
    protected int value;

    public void instanceMethod() {
        Test5B a = new Test5B() {{ value = 1; }};
        System.out.println(this.value);
        System.out.println(a.value);
    }

    public static void main(String[] args) {
        new Test5B().instanceMethod();
    }
}