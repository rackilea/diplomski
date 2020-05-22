List<Base> process(List<A> list) {
    List<Base> result = new ArrayList<>();
    for (A a : list) {
        result.add(a);
        result.addAll(a.getListOfB());
    }
    return result;
}

interactor.getTheContainer() // This returns a Single<Container>
    .subscribeOn(Schedulers.io())
    .map(new Function<Container, List<Base>>() {
        @Override public List<Base> apply(Container c) {
             return process(c.getListOfA());
        }
    })
    .observeOn(AndroidSchedulers.mainThread())
    .subscribeWith(new DisposableSingleObserver<List<Base>>() {
        @Override public void onSuccess(final List<Base> value) {
           /* display the list */
        }
    })