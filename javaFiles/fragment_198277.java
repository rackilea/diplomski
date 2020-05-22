columnName.setCellFactory(new Callback<TableColumn<YourEntity, Boolean>, TableCell<YourEntity, Boolean>>() {
          @Override public TableCell<YourEntity, Boolean> call(TableColumn<YourEntity, Boolean> BooleanTableColumn) {
            Stage stage = null;
            return new AddImage(stage, yourTableviewName);
          }
        });