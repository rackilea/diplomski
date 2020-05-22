class Parent {

    String name;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Child> children = new ArrayList<>();

    public void addChild(Child child) {
        child.setParent(this);
        children.add(child);
    }

    public void removeChild(Child child) {
        children.remove(child);
        child.setParent(null);
    }
}

class Child {

    String name;

    @ManyToOne
    Parent parent;

    @OneToOne(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    Toy toy;
}

class Toy {
    String name;

    @OneToOne
    Child child;
}