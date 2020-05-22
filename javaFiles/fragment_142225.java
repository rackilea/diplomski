@Entity
public class Contact
    @Id
    private Long id;

    @ManyToOne
    @JoinTable(name = "JOIN_CONTACTS_PERSON", 
               joinColumns=
                   @JoinColumn(name="CONT_ID"),
               inverseJoinColumns=
                   @JoinColumn(name="PERS_ID"))
    private Person owningPerson;

    @ManyToOne
    @JoinTable(name = "JOIN_CONTACTS_INSTITUTION", 
               joinColumns=
                   @JoinColumn(name="CONT_ID"),
               inverseJoinColumns=
                   @JoinColumn(name="INST_ID"))
    private Institution owningInstitution;

    // ...
}