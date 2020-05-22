class Aggregate<T, U> {
    List<T> tList = new ArrayList<>();
    List<U> uList = new ArrayList<>();

    public void add(Either<T, U> e) {
        if(e.isLeft()) {
            tList.add(e.left());
        } else {
            uList.add(e.right());
        }
    }

    public Aggregate<T, U> combine(Aggregate<T, U> other) {
        tList.addAll(other.tList);
        uList.addAll(other.uList);
        return this; // could create a new Aggregate here instead...
    }

    public static <T, U> Collector<Either<T,U>, ? , Aggregate<T, U>> partitionEithers() {
        return Collector.of(Aggregate::new, Aggregate::add, Aggregate::combine);
    }
}