FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
    try {
        fullTextEntityManager.createIndexer(standardEntity.class).batchSizeToLoadObjects( 1000 )
        .cacheMode( CacheMode.IGNORE ).threadsToLoadObjects( 20 ).threadsForSubsequentFetching( 50 )
        .startAndWait();        
    } catch (InterruptedException e) {
        e.printStackTrace();
    }