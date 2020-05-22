setFilters(new Function<Color, Color>() {
    @Override
    public Color apply(Color color) {
        return color.darker();
    }
});