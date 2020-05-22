@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nationalCode;
    private String firstName;
    private String lastName;
    @Column(name = "gender", columnDefinition = "number(3)", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    //getters and setters
}