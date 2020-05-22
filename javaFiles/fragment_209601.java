@Entity
@Inheritance
@Table(name = "buildings")
@DiscriminatorColumn(name="type")
public class Building {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;
}