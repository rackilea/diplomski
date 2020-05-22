btnInsert.setOnAction(e -> {
    try {
        Insert();
    } catch (SQLException ex) {
        throw new RuntimeException(ex); // Or any other subclass of RuntimeException or Error
    }
});