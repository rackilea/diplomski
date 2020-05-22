List<CaseData> cases = (List<CaseData>) model.get("cases");
    Sheet sheet = workbook.createSheet("PIE Cases");

int rowCount = 1;
    for (CaseData pieCase : cases) {
        Row userRow = sheet.createRow(rowCount++);

if (pieCase.getActualAmountReturned() != null) {
           userRow.createCell(2).setCellValue(pieCase.getActualAmountReturned());
}
if (pieCase.getChannel() != null) {
            userRow.createCell(9).setCellValue(pieCase.getChannel().getChannel());
}