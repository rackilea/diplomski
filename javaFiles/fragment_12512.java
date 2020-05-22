realm.executeTransaction(new Realm.Transaction() {
    @Override
    public void execute(Realm realm) {
        List<Article> realmArticles = realm.copyToRealmOrUpdate(articles.data);

        for(Article article : realmArticles) {
            Author author = realm.where(Author.class).equalTo("id", article.getSerializedAuthor()).findFirst();
            article.setAuthor(author);

            for (Image image : article.getSerializedImages().data) {
                article.getImages().add(image);
            }
        }
    }
});