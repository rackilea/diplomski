@Entity
@Table(name = "MY_SCHEMA.MY_TABLE_A")
@Component
public class FirstClass implements Serializable {

    @Id
    @SequenceGenerator(name = "MY_SEQ", sequenceName = "MY_SCHEMA.MY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_SEQ")
    @Column(name = "MY_ID")
    private Long myId;

    @OneToOne(mappedBy = "firstClass", cascade = CascadeType.ALL)
    private SecondClass secondClass;
}

@Entity
@Table(name = "MY_SCHEMA.MY_TABLE_B")
@Component
public class SecondClass implements Serializable {

    @Id
    @JoinColumn(name = "MY_ID", referencedColumnName = "MY_ID")
    @OneToOne
    private FirstClass firstClass;
}