class A {
    List<A> as;

    public int getDepth() {
        return 1 + as.stream().mapToInt(A::getDepth).max().orElse(0);
    }
}