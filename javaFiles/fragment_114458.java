interface Predicate<A> {
    boolean eval(A argument);
}

Predicate<Integer> gt0 = new Predicate<Integer>() {
    boolean eval(Integer arg) {
        return arg > 0;
    }
};