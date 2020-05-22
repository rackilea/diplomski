// starting boundary values
String dateFrom = "2015-01-01";
int hourFrom = 700;
String dateTo = "2015-01-03";
int hourTo = 600;

String formatString = "%s %04d"; // adjust as necessary.

String fromDateTime = String.format(formatString, dateFrom, hourFrom);
String toDateTime = String.format(formatString, dateTo, hourTo);

// execute query here

while (rs.next()) {
    String dateTime = String.format(formatString, rs.getString("date"), rs.getInt("hour"));

    if (fromDateTime.compareTo(dateTime) > 0 || toDateTime.compareTo(dateTime) < 0) {
        throw new Exception("fail unit test");
    }
}