regularityColumn.setCellFactory(TextFieldTableCell.forTableColumn(
            new StringConverter<Integer>(){
            Integer fromString(String s) {
                 //convert the string to integer yourself and catch the exception
            }

            String toString(Integer i) {
                 //convert the integer to String yourself and catch the exception
            }
        }
    )
);