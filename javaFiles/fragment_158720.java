public static List<Article> getAllArticles(){
    Session se=openSession();
    List<Article> li= (List<Article>)(se.createCriteria(Article.class).list());
    se.close();
    return li;
}