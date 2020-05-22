class Child implements Comparable<Child>{
    private String name;

    public Child(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Child child) {
        return name.compareTo(child.name);
    }
}