class A {
    public void foo() {
        List<String> list = ...
        list.forEach( s -> { System.out.println(s); } );
    }
}