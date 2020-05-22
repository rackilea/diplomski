enum ArticleType {
    ONLINE, PAPER
}

class Article implements Comparable<Article> {

    int year;
    int month;
    ArticleType type;

    Article(int year, int month, ArticleType type) {
        this.year = year;
        this.type = type;
        this.month = month;
    }

    @Override
    public int compareTo(Article o) {
        return new CompareToBuilder()
                .append(this.type, o.type)
                .append(this.year, o.year)
                .append(this.month, o.month)
                .toComparison();

    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("month", month)
                .add("year", year)
                .add("type", type)
                .toString();
    }
}

@Test
public void testSortArticles() throws Exception {
    List<Article> articleList = new ArrayList<>();
    articleList.add(new Article(2012, 1, ArticleType.ONLINE));
    articleList.add(new Article(2011, 1, ArticleType.ONLINE));
    articleList.add(new Article(2011, 6, ArticleType.ONLINE));
    articleList.add(new Article(2010, 1, ArticleType.ONLINE));
    articleList.add(new Article(2010, 1, ArticleType.PAPER));
    articleList.add(new Article(2010, 2, ArticleType.PAPER));
    articleList.add(new Article(2010, 3, ArticleType.PAPER));
    articleList.add(new Article(2012, 1, ArticleType.PAPER));
    articleList.add(new Article(2012, 9, ArticleType.PAPER));

    Collections.sort(articleList);

    System.out.println(articleList);
}