col_CheckBox.setCellFactory(CheckBoxTableCell.forTableColumn(new Callback<Integer, ObservableValue<Boolean>>() {
        @Override
        public ObservableValue<Boolean> call(Integer param) {
            // TODO Auto-generated method stub
            return tableView.getItems().get(param).chekboxStudentRowProperty();
        }
    }));