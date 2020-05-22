@Entity
public class Users{
    @Id @Column(name = "user_id") @JsonProperty("userId")
    private int id;

    @JsonUnwrapped
    @ManyToOne @JoinColumn("city_id")
    private City city;

    // other fields, getters, setters
}