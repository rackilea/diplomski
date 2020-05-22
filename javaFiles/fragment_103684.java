@Entity
@Table( name="CONTACT" )
public class Contact {

    @Id @Column
    private Long pid;

    @Column
    private String phoneNumber;

    // getters and setters
}