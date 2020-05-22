Collections.sort(unSorted, new Comparator<Article>() {
    @Override
    public int compare(Article a, Article b) {
        int articleNumberOne = Integer.parseInt(a.getArticleNumber());
        int articleNumberTwo = Integer.parseInt(b.getArticleNumber());

        return Integer.compare(articleNumberOne, articleNumberTwo);
                }
            }