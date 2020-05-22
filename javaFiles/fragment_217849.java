ClassB {

    private Set<ClassA> linkedObjects;

    .... 

    @OneToMany(mappedBy="place")
    @ContainedIn
    public Set<ClassA> getLinkedObjects() {
        return linkedObjects;
    }

    ....
}