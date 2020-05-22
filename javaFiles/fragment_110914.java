@Entity
@Table(name="world")
@JsonSerialize(include = Inclusion.NON_NULL) //New Line!!!
public class World implements Serializable {
...
...
}