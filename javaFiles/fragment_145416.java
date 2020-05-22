public void createArticle(ArticleDTO dto) {
    Article article = new Article();
    // some business logic.
    article.setTitle(dto.getTitle());
    article.setSubtitle1(dto.getSubTitle());
   // more business may be.
    articleDAO.create(article);
}