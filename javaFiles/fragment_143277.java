public static String toMysqlDateStr(Date date) {
String dateForMySql = "";
if (date == null) {
    dateForMySql = null;
} else {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    dateForMySql = sdf.format(date);
}

return dateForMySql;