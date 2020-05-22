grid.setCellStyleGenerator(new Grid.CellStyleGenerator() {
    @Override
    public String getStyle(Grid.CellReference cellReference) {
        if ("c1".equals(cellReference.getPropertyId())) {
            return "green";
        } else if ("c2".equals(cellReference.getPropertyId())) {
            return "right-and-left-border";
        } else {
            return null;
        }
    }
});