@Entity
public class LocalizedArticle{

    @ManyToOne
    private Article container;

    @Id
    private Long id;

    private String body;

    private String title;

    private String locale;

}