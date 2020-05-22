class Wall {

    private final Set<Squares> dots = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        return dots.equals(((Wall)obj).dots);
    }
    @Override
    public int hashCode() {
        return dots.hashCode();
    }
}