@Entity
public class Foo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId(){

    }
    ...
    @OneToMany(mappedBy="foo")
    public Collection<Bar> getBars() {

    }


...
}


@Entity
@IdClass(BarPk.class)
public class Bar implements Serializable {
    @ManyToOne
    @JoinColumn(name="foo")
    @Id
    public Foo getFoo() {
        return foo;
    }

    @Column(name="key", length=255)
    @Id
    public String getKey(){

    }

}


@Embeddable
public class BarPk implements Serializable {
    public Foo getFoo() {
        return foo;
    }
    public void setFoo(Foo foo) {

    }
    public String getKey(){
    ...
    }   

    public void setKey(String key){
    ...
    }     

    //you must include equals() and hashcode()    
}