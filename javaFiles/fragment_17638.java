public class View {
    interface Summary {}
}

public class User {

    @JsonView(View.Summary.class)
    private Long id;

    @JsonView(View.Summary.class)
    private String firstname;

    @JsonView(View.Summary.class)
    private String lastname;

    private String email;
    private String address;
    private String postalCode;
    private String city;
    private String country;
}