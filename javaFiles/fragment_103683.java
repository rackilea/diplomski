@Entity
@Table( name="PEOPLE" )
public class People {

    @Id @Column
    private Long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn( name="pid" )
    private Contact contact;

    // getters and setters
}