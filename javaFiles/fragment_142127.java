@Entity
public class Article{

    @Id
    private Long id;

    @OneToMany(mappedBy="container")
    private Set<LocalizedArticle> localizedArticles;

}