cell.textProperty().bind(new StringBinding() {
    {
        bind(cell.textProperty(), cell.emptyProperty());
    }
    @Override
    public String computeValue() {
        return cell.isEmpty() ? "" : String.format("%s", cell.getItem()) ;
    }
});