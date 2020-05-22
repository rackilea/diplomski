grid.setCellStyleGenerator(new Grid.CellStyleGenerator() {
    @Override
    public String getStyle(Grid.CellReference cellReference) {
        if ("c1".equals(cellReference.getPropertyId())) {
            return "green";
        } else {
            return null;
        }
    }
});