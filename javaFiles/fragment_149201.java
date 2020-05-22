class Parent {
    private Kid kid;
    public Parent() {
        kid = new Kid(this);
    }
}

class Kid {
    private Parent parent;
    public Kid(Parent p) {
        parent = p;
    }
}