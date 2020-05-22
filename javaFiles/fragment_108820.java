@Entity
@Where(clause = "isDeleted='false'")
public class Customer {
    //...
    @Column
    private Boolean isDeleted;
}