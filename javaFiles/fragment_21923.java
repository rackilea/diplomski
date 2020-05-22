public Observable<List<Anime>> getOnlyAnimeObservable() {
    List<Anime> list = getOnlyAnimeList();
    if (list == null) {
        list = Collections.emptyList();
    }
    return Observable.just(list);
}