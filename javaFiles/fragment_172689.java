private Observable<FeaturedItemList> mFeatured =
    // initialized on construction
    getFromNetwork()
        .retry(3) // number of times to retry
        .cache();

public Observable<FeaturedItemList> getFeatured() {
    return mFeatured;
}