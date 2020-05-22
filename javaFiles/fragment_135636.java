try{
    ...
} catch (SQLException e) {
    SQLWarning sqlWarning = currentStatement.getWarnings();
    if (sqlWarning != null) {
        warning = sqlWarning.getMessage();
    }
}