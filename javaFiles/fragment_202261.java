@Entity
public class Person {

    @Id 
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @Transient
    private Boolean shouldSendEmail;

}