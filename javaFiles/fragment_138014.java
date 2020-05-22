SummaryInformation summaryInfo = workbook.getSummaryInformation();
if (summaryInfo != null) {
    if (summaryInfo.getTitle() != null) {
        System.out.println(summaryInfo.getTitle());
    }
    if (summaryInfo.getAuthor() != null) {
        System.out.println(summaryInfo.getAuthor());
    }
}