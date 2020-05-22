colUsable.setCellFactory(new Callback<TreeTableColumn<MyType,Boolean>,TreeTableCell<MyType,Boolean>>() {
    @Override 
    public TreeTableCell<MyType,Boolean> call( TreeTableColumn<MyType,Boolean> p ) {
        CheckBoxTreeTableCell<MyType,Boolean> cell = new CheckBoxTreeTableCell<MyType,Boolean>();
        cell.setAlignment(Pos.CENTER);
        return cell;
    }
});