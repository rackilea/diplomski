static class B extends A implements Comparable<B> {
    @Override
    public int compareTo(B o) {
        return super.compareTo(o);
    }
}