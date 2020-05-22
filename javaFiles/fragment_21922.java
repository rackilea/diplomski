public Observable<List<Anime>> getOnlyAnimeObservable() {
    List<Anime> onlyAnimeList = getOnlyAnimeList();
    if (onlyAnimeList == null) {
        List<Anime> list = Collections.emptyList();
        return Observable.just(list);
    }
    return Observable.just(onlyAnimeList);
 }