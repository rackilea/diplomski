@Entity
@NamedQuery(name = "findAllBooks", query = "select b from Book b")
public class Book implements Serializable {

@Id
@GeneratedValue
private long id;

...

}