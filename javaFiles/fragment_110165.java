static class A {}
static class B extends A implements Comparable<A>{
    @Override
    public int compareTo(final A o) {
        return 0;
    }
}