static boolean boldsie = false;

    public static void main(String... args) {
        File excel = new File("\\test.xlsx");
        FileInputStream fis;
        try {
            fis = new FileInputStream(excel);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet ws = wb.getSheet("Sheet1");

            int rowNum = ws.getLastRowNum() + 1;
            int colNum = ws.getRow(0).getLastCellNum();
            String[][] data = new String[rowNum][colNum];

            for (int i = 0; i < rowNum; i++) {
                XSSFRow row = ws.getRow(i);
                for (int j = 0; j < colNum; j++) {
                    XSSFCell cell = row.getCell(j);
                    String value = cell.toString();
                    data[i][j] = value;

                    showDataInTextPane(ws, cell.getReference());

                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void showDataInTextPane(XSSFSheet ws, String reference) {
        JFrame frame = new JFrame("Formatted POI Sample");
        Container content = frame.getContentPane();
        JPanel panel = new JPanel();

        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");

        textPane.setText(getHtmlFromExcel(ws, reference));

        panel.setLayout(new BorderLayout());
        panel.add(textPane);

        content.add(panel);
        frame.setSize(100, 100);
        frame.setVisible(true);
    }

    public static String getHtmlFromExcel(XSSFSheet sheet, String cellName) {

        CellReference cellReference = new CellReference(cellName);
        XSSFRow row = sheet.getRow(cellReference.getRow());
        XSSFCell cell = row.getCell(cellReference.getCol());

        XSSFRichTextString cellText = cell.getRichStringCellValue();

        String htmlCode = "";

        for (int i = 0; i < cellText.numFormattingRuns(); i++) {
            try {
                htmlCode += getFormatFromFont(cellText.getFontAtIndex(i));
            } catch (NullPointerException ex) {

            }
            try {
                htmlCode += getFormatFromFont(cellText
                        .getFontOfFormattingRun(i));
            } catch (NullPointerException ex) {

            }

            htmlCode += cellText.getString().substring(
                    cellText.getIndexOfFormattingRun(i),
                    cellText.getIndexOfFormattingRun(i)
                            + cellText.getLengthOfFormattingRun(i));
        }

        if (boldsie) {
            htmlCode += "</b>";
            boldsie = false;
        }

        return htmlCode;
    }

    private static String getFormatFromFont(XSSFFont font) {
        String formatHtmlCode = "";
        if (font.getBold() && !boldsie) {
            formatHtmlCode += "<b>";
            boldsie = true;
        } else if (!font.getBold() && boldsie) {
            formatHtmlCode += "</b>";
            boldsie = false;
        }

        return formatHtmlCode;
    }