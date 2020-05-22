secondCol.setCellFactory(
        new Callback<TreeTableColumn<Employee, String>, TreeTableCell<Employee, String>>() {
             @Override
             public TreeTableCell<Employee, String> call(
                TreeTableColumn<Employee, String> param) {
                    return new ProgressCell();
                }
});