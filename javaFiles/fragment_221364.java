plot.setLabelGenerator(new StandardCategoryItemLabelGenerator() {

    @Override
    public String generateColumnLabel(CategoryDataset dataset, int col) {
        return dataset.getColumnKey(col) + " " + dataset.getValue(0, col);
    }
});