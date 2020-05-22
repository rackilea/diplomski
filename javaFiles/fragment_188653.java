@Entity
@Table(name="user")
public class User implements Serializable {

   // user properties

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    public Address getAddress() {
        return this.address;
    }

}