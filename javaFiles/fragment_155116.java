@MappedSuperclass
@DiscriminatorColumn(name = "class_name")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class LookupTable{

    @Id
    private Long vale;

    @Column(nullable = false)
    private String description;

    // Getters and setters
}

@Entity
@DiscriminatorValue("GENDER_CODE")
public class GenderCode extends LookupTable() {

}


@Entity
@DiscriminatorValue("BANK_CODE")
public class BankCode extends LookupTable() {

}

@Entity
public class Employee{

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private GenderCode genderCode;

    @Column(nullable = false)
    private BankCode bankCode;
}