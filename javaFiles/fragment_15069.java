@Entity
public class A implements Serializable{
    @Id
    @Column(name = "REF")
    private int ref;

    @OneToMany
    @JoinColumn(name = "A_REF", referencedColumnName = "REF")   
    @Filter(name="test")
    private Set<B> bs;
}

@Entity
@FilterDef(name="test", defaultCondition="other = 123")
public class B implements Serializable{
    @Id
    @Column(name = "A_REF")
    private int aRef;

    @Id
    @Column(name = "OTHER")
    private int other;
}

Session session = entityManager.unwrap(Session.class);
session.enableFilter("test");
A a = entityManager.find(A.class, new Integer(0))
a.getb().size() //Only contains b that are equals to 123