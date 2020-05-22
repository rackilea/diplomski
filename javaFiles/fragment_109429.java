Observable<PageProvider.Page> getPages() {
    BehaviorSubject<String> pageControl = BehaviorSubject.create((String)null);
    Observable<PageProvider.Page> ret = pageControl.asObservable()
            .concatMap(apageIndex ->
                       provider.getPage(apageIndex).toObservable().doOnNext(
                               page-> {
                                   if (page.next == null)
                                       pageControl.onCompleted();
                                   else
                                       pageControl.onNext(page.next);
                               }));
    return ret;
}