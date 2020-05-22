public static class CombinedListTransformer<T,R> implements Observable.Transformer<List<T>,List<R>> {

    private final Func1<T,Observable<List<R>>> listMapper;

    public CombinedListTransformer(Func1<T,Observable<List<R>>> listMapper) {
        this.listMapper = listMapper;
    }
    @Override
    public Observable<List<R>> call(Observable<List<T>> sourceList) {
        return sourceList.flatMap(sl ->
            Observable.from(sl).map(t -> listMapper.call(t)).toList() //List<Observable<List<R>>
            .flatMap(consolidatedChildList -> Observable.combineLatest(consolidatedChildList, args -> {
                ArrayList<R> list = new ArrayList<>();
                for (Object obj : args) {
                    list.addAll((List<R>) obj);
                }
                return list;
            }))
        );
    }
}