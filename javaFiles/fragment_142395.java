public class LoginForm implements Serializable {

    @NotNull
    @Column(name="username", unique=true)
    @Size(min=5)
    private String username;

    @NotNull
    @Size(min=5)
    private String password;

    //Getters and Setters

}