@Embeddable
public class PersonName extends BaseName {
    @Column(name = "title")
    private String title;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "suffix")
    private String suffix;

    // ...
}