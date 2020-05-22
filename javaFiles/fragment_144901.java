class CstmStandardCategoryItemLabelGenerator extends StandardCategoryItemLabelGenerator {

    @Override
    public String generateLabel(CategoryDataset dataset, int row, int column) {
        return String.format("%.1f %%", dataset.getValue(row, column).doubleValue() * 100.0);
    }
}