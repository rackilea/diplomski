@PostConstruct
public void init() {
    Article article = new Article("Welcome");
    this.article = article;
    injectedBean.setArticle(article);
}