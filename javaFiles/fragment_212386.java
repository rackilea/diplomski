Observable<ArtistsCursorPager> allPages = Observable.defer(() ->
{
    BehaviorSubject<Object> pagecontrol = BehaviorSubject.create("start");
    Observable<ArtistsCursorPager> ret = pageControl.asObservable().concatMap(aKey ->
    {
        if (aKey != null && aKey.equals("start")) {
            return Observable.getFollowedArtists(50).doOnNext(page -> pagecontrol.onNext(page.cursors.after));
        } else if (aKey != null && !aKey.equals("")) {
            return Observable.getFollowedArtists(50,aKey).doOnNext(page -> pagecontrol.onNext(page.cursors.after));
        } else {
            return Observable.<ArtistsCursorPager>empty().doOnCompleted(()->pagecontrol.onCompleted());
        }        
    });
    return ret;
});