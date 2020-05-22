public void testgetAllRatingElementsWeekNo() throws Exception
{
try {
    String METHOD_NAME = "testgetAllRatingElementsWeekNo";
    log.entering(CLASS_NAME, METHOD_NAME);

    populateForTestMethodValues("1");
    populateWeekOfList();
    int allRatingElementsWeekNo = weeklyDlvyInstancesDashboardReportForm.getAllRatingElementsWeekNo();
    System.out.println("allRatingElementsWeekNo :" + allRatingElementsWeekNo );
    assertEquals("testgetAllRatingElementsWeekNo is Not Greater than Zero: ", allRatingElementsWeekNo > 0, allRatingElementsWeekNo);
} finally {
    log.exiting(CLASS_NAME, METHOD_NAME);
}
}