@Entity
@Table(name = "PERSON_DETAILS")
public class PersonDetails {
    @Id
    private Long personId; 

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON", nullable = false)
    @MapsId
    private Person person;
    ....
}

@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "SQ_PRSN_ID", sequenceName = "SQ_PRSN_ID")
public class Person{
    @Id
    @GeneratedValue(generator = "SQ_PRSN_ID", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PERSON", nullable = false)
    private Long personId;
    ...
}