@Entity
public class Article {
    @OneToMany(cascade=CascadeType.MERGE)
    private List<Images> images;
}

@Transactional
public void createArticle() {
    //images created as Java objects in memory, no DAOs called yet
    List<Image> images = ...  
    Article article = getArticle();
    article.addImages(images);
    // cascading will save the article AND the images
    em.merge(article);
}