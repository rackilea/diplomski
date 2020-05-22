@Entity
public class OtherInfo {
    @Id @GeneratedValue(generator = "customForeignGenerator")
    @org.hibernate.annotations.GenericGenerator(
        name = "customForeignGenerator",
        strategy = "foreign",
        parameters = @Parameter(name = "property", value = "person")
    )
    private Long id;

    @OneToOne(mappedBy="otherInfo")
    @PrimaryKeyJoinColumn
    public Person person;

    rest of attributes ...
}