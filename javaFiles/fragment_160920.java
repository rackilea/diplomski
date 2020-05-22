int x = 0;
while (rs.next()) {
    articleList.add(new Article());
    articleList.get(x).setArticleName(rs.getString("article_name"));
    articleList.get(x).setArticleBody(rs.getString("article_body"));
    articleList.get(x).setArticleAuthor(rs.getString("article_author"));
    articleList.get(x).setArticleDate(rs.getString("article_date"));
    articleList.get(x).setArticleId(rs.getString("article_id"));
    articleList.get(x).setArticleComments(this.getCommentsNum(articleId));
    x++;
}