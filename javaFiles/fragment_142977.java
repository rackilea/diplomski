private A reference;

    private String name;

    public A() {
        reference = this;
    }

    public void setReference(A ref) {
        reference = ref;
    }

    public void setName(String name) {
        reference.name = name;
    }

    public String getName() {
        return reference.name;
    }

}