public static java.sql.Date convertFromJAVADateToSQLDate(
        java.util.Date javaDate) {
    java.sql.Date sqlDate = null;
    if (javaDate != null) {
        sqlDate = new Date(javaDate.getTime());
    }
    return sqlDate;
}