class MyBean {
    private String foo;
    private String bar;
    private boolean fooSet;

    public String getFoo() {
        return this.foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
        this.fooSet = true;
    }

    public String getBar() {
        return this.bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public boolean isFooSet() {
        return this.fooSet;
    }
}