public Timestamp getPriorTimestamp(final Session session, final String testDateText) throws ParseException {
    final SQLQuery theQuery = session.createSQLQuery(
            "SELECT MAX(TIME_STAMP) FROM TIME_STAMP_EVENT WHERE TIME_STAMP < :theTimeStamp AND EXISTS (SELECT 1 FROM TIME_STAMP_EVENT SEMI_TIME WHERE SEMI_TIME.TIME_STAMP = :theTimeStamp)");
    return (Timestamp) theQuery.setTimestamp("theTimeStamp",
            (new SimpleDateFormat("dd-MMM-yyyy").parse(testDateText)))
            .uniqueResult();
}