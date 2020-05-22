@Entity
@Immutable
@Table(name = "cities")
public class City {
    @Id private Integer id;
    private String name;
}