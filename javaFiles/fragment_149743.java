public final class NestedInfiniteTest {

    private static final BehaviorSubject<Integer> parentSubject = BehaviorSubject.create(1);
    private static final BehaviorSubject<Integer> childSubject = BehaviorSubject.create(1);

    public static void main(String[] args) {

        Observable<List<Parent>> infiniteParentListStream = parentSubject
                .map(i -> IntStream.range(0,i).mapToObj(val -> new Parent()).collect(Collectors.toList()))
                .cache(1);

        Observable<List<Child>> allCurrentChildren = infiniteParentListStream.flatMap(parentList ->
                Observable.<Observable<List<Child>>>create(s -> {
                    parentList.stream().map(Parent::getInfiniteChildListStream).forEach(s::onNext);
                    s.onCompleted();
                })
                .toList() //List<<Observable<List<Child>>>>
                .flatMap(consolidatedChildList -> Observable.combineLatest(consolidatedChildList, new FuncN<List<Child>>() {
                    @Override
                    public List<Child> call(Object... args) {
                        ArrayList<Child> list = new ArrayList<>();
                        for (Object obj : args) {
                            list.addAll((List<Child>) obj);
                        }
                        return list;
                    }
                }))
        );


        allCurrentChildren.subscribe(cl -> System.out.println("WHOLE CHILD LIST SIZE: " + cl.size()));
        childSubject.onNext(10);
        parentSubject.onNext(5);
        childSubject.onNext(2);
    }

    private static final class Parent {
        private final Observable<List<Child>> infiniteChildListStream = childSubject
                .map(i -> IntStream.range(0, i).mapToObj(val -> new Child()).collect(Collectors.toList())).cache(1);

        public Observable<List<Child>> getInfiniteChildListStream() {
            return infiniteChildListStream;
        }
    }
    private static final class Child {

    }
}