// since all references are unique we can use that, but see below
Map<R, A> mappedArticles = new IdentityHashMap<>();

// inject articles based on references in the map, then

A article;

for (B basket: bean.getBasket())
    article = mappedArticles.get(basket.getArticleReferences());
    if (article != null)
        article.setAddedToBasket(true);

// Full list of articles is in the map's .values()