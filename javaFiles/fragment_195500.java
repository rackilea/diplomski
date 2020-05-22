studentTable.setRowFactory(tableView -> new TableRow<Attendance>() {
    @Override
    protected void updateItem(Attendance attendance, boolean empty) {
        super.updateItem(attendance, empty);
        if (empty) {
            setStyle("");
        } else if (attendance.getStatus().equals("present")) {
            setStyle("-fx-background-color:green;");
        } else if (attendance.getStatus().equals("absent")) {
            setStyle("-fx-background-color:red;");
        } else {
            setStyle("-fx-background-color:white;");
        }
    }
});