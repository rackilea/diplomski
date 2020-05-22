@Entity    
class ObjectA {
    @Id @GeneratedValue
    private Integer id:
    private String name;
    @OneToOne(mappedBy = "a")
    private ObjectB activeB;
}

@Entity
class ObjectB {
    @Id @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn(name = "idTableA")
    private ObjectA a;
    private Date dateClosed;
}