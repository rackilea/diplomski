@Entity
    @Table(name="A")

    public class A  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idA")
    private int idA;
    @OneToMany(fetch=FetchType.EAGER)
    private List<C> listofC ;

///GETTERS AND SETTERS
}