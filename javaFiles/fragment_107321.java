class NewspaperArticle {
  ArticleData articleData;
  Date printDate = null;

  NewspaperArticle(Article createFrom) {
    this.articleData = createFrom.getArticleData();
  }
}