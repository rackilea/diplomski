@Entity
    @Table(name="C")

    public class C implements Serializable {
    @Id
    @Column(name="idC")
    private int idC;

    @Column(name="value")
    private int value;

    @OneToOne   
    private B b;  


///GETTERS AND SETTERS
}