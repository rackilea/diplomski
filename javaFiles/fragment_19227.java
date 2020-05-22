interface VoidFunction {
    void evaluate();
}

...

List<VoidFunction> list = new ArrayList<>();

VoidFunction aaa = new VoidFunction() {
    @Override
    public void evaluate() {
        aaa();
    }
}

list.add(aaa);