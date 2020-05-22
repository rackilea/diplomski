columnDate.setCellFactory(column -> {
    TableCell<PatientEntity, Date> cell = new TableCell<PatientEntity, Date>() {
        private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        @Override
        protected void updateItem(Date item, boolean empty) {
            super.updateItem(item, empty);
            if(empty) {
                setText(null);
            }
            else {
                setText(format.format(item));
            }
        }
    };

    return cell;
});