@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String personId;

    @ManyToOne
    @JoinColumn(name="leader_id")
    private Leader leader;
    //getter and setter

}