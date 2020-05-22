Binding<Color> importantTreesColor = new ObjectBinding<Color>() {
    { bind(importantTree); }
    @Override
    protected Color computeValue() {
        return importantTree.get()==null ? null : importantTree.get().getColor();
    }
};