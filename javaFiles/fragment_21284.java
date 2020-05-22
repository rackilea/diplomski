@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String year;

    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Actor> actors;

    public Movie(String title, String genre, String year, List<Actor> actors) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        actors.forEach(a -> a.addMovie(this));
    }

    // Getters and setters...
}