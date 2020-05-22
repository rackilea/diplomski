public static void main(String[] args) {
    try {
        Document document = new Document();
        document.setPageSize(PageSize.LETTER);
        document.setMargins(16, 14, 14, 14);
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("SplitLastRow.pdf"));
        document.open();
        document.setPageSize(PageSize.LETTER);
        document.setMargins(16, 14, 42, 38);

        for (int m = 1; m < 20; m++) {

            int row = 0;
            PdfPTable table = new PdfPTable(1);
            table.setSpacingAfter(0);
            table.setSpacingBefore(0);
            table.setTotalWidth(document.right() - document.left());
            table.setLockedWidth(true);

            table.setHeaderRows(1);
            table.setSkipFirstHeader(true);
            add(table, "Header Row continued " + m, BaseColor.LIGHT_GRAY, row++);
            add(table, "Header Row normal " + m, BaseColor.LIGHT_GRAY, row++);

            add(table, "Text Row 1 ", BaseColor.WHITE, row++);
            add(table, "Text Row 2 ", BaseColor.WHITE, row++);
            add(table, "Text Row 3 ", BaseColor.WHITE, row++);

            addPadding(table);
            if (writer.getVerticalPosition(true) - table.getRowHeight(0) - table.getRowHeight(1) < document.bottom()) {
                document.newPage();
            }
            document.add(table);
        }

        document.close();
    } catch (Exception de) {
        de.printStackTrace();
    }
}