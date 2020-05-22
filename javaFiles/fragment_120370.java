@Data
@Entity
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String title;

@ManyToOne(cascade=CascadeType.ALL)
private Author author;

}