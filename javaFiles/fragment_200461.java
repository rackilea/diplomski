btnInsert.setOnAction(e -> {
    try {
        Insert();
    } catch (SQLException ex) {
        // Log error, show error message, etc... Whichever is applicable for your application
    }
});