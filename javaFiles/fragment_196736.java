@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "name")
    private String name; //User specific properties

    //..setters and getters here
}