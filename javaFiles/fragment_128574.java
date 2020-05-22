public class ClassA extends [...] implements [...] {
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = JOIN_TABLE_NAME,
            joinColumns = @JoinColumn(name = COLUMN_REF_A, referencedColumnName = COLUMN_ID_A),
            inverseJoinColumns = @JoinColumn(name = COLUMN_REF_B, referencedColumnName = COLUMN_ID_B))
    private List<ClassB> fieldClassB; 

    public void addClassB(ClassB b) {
        fieldClassB.add(b);
        b.fieldClassA().add(this);
    }

    public void removeClassB(ClassB b) {
        fieldClassB.remove(b);
        b.fieldClassA().remove(this);
    }  
}