package database.mariadb.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Michael
 * Creation date 3/21/2017.
 * @link
 */
public class Contact {

    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String email;

    public Contact(String firstName, String lastName, String city, String state, String email) {
        this(null, firstName, lastName, city, state, email);
    }

    public Contact(Long id, String firstName, String lastName, String city, String state, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("city", city)
                .append("state", state)
                .append("email", email)
                .toString();
    }
}