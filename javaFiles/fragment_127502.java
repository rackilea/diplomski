class MyClass {
    // the keys should be looked up from resource bundle
    @TomActionBinding("go", "text-key", "msg-key", "icon-key");
    Action act;

    public MyClass() {
       JButton btn = new JButton(act);
    }

    private void go() {
       // do task
    }

}