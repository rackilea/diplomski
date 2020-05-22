@Entity(name = "Post")
@Table(name = "post")
public class Post {

    @Id
    private Long id;

    private String title;

    @Column(name = "created_on")
    private LocalDate createdOn;

    public Long getId() {
        return id;
    }

    public Post setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public Post setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
        return this;
    }
}