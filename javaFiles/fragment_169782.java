@Entity
@Table(name = "address")
public class Address {
    // other fields

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    // getters, setters, constructors etc.
}