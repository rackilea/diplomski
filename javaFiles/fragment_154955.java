public List<Article> listerArticleById(int id) {
    List<Article> articles = getEntityManager()
            .createQuery(
                    "SELECT article FROM Article article WHERE article.professionel.id=:param1")
            .setParameter("param1", id).getResultList();
    return articles;
}