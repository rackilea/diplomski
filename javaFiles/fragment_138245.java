@Entity
public class A {
    private Date lastModified;

    @OneToMany(mappedBy = "a", cascade = CascadeType.ALL)
    private List<B> blist;

    public void touch() {
        lastModified = new Date();
    }
}

public class B {
    @ManyToOne
    private A a; 

    @PreUpdate
    public void ensureParentUpdated() {
        if (a != null) {
            a.touch();
        }
    }
}