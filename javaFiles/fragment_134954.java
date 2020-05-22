public boolean isDataExist(Employee emp) {
    List<String> tableNames = List.of("Table1", "Table2", "Table3");

    for (String tableName : tableNames) {
        if (existsInTable(tableName, emp.getId())) {
            return true;
        }
    }

    return false;
}

private boolean existsInTable(String tableName, Long employeeId) {
    String query = String.format("SELECT count(*) FROM %s WHERE emp_id=:id", tableName);

    long count = (long)session
            .createQuery(query)
            .setParameter("id", employeeId)
            .getSingleResult();

    return count > 0;
}