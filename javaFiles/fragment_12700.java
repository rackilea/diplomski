@Entity
@Data  // lombok.Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="in_cinemas")
    private boolean inCinemas;
}