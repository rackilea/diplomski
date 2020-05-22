java.util.Date date = getMyDate();
if (date == null) {
    statement.setNull(insertionIndex, Types.TIMESTAMP);
} else {
    statement.setTimestamp(insertionIndex, new Timestamp (date.getTime()));
}