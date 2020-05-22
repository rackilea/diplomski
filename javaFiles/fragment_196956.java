class A {
    public void foo() {
        List<String> list = ...
        list.forEach( [lambda for lambda$1 as Consumer] );
    }

    static void lambda$1(String s) {
        System.out.println(s);
    }
}