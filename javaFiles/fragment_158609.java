renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
    @Override
    public String generateToolTip(CategoryDataset dataset, int row, int column) {
        String s = super.generateToolTip(dataset, row, column);
        int b = s.indexOf('(', 1) + 1;
        int e = s.indexOf(')');
        return s.substring(b, e);
    }
});