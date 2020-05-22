final MyDAO dao = ...;
Callable<Foo> callable = new Callable<>() {
    @Override
    public Foo call() {
        return dao.someMethod(1, 2, 3);
    }
};