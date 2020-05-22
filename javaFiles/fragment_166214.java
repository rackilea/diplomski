public static void main(String[] args) {

    class Foo {
        public void bar() {
            System.out.println("inside Foo#bar()");
        }
    }

    Foo foo = new Foo();
    foo.bar();
}