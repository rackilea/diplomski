class Foo {

    Process p;

    private void doStuff() throws Exception {
        p = Runtime.getRuntime().exec("program.py", envp);
        // More code ...
    }

    private void startStuff() {
        try {
            doStuff();
        } catch (Exception e) {
            p.destroy();
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.startStuff();
    }
}