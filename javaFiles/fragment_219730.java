// slurp content from given input and close it
    public static boolean isExcelFile(InputStream in) throws IOException {
        try {
            // it slurp the input stream
            Workbook workbook = org.apache.poi.ss.usermodel.WorkbookFactory.create(in);
            workbook.close();
            return true;

        } catch (java.lang.IllegalArgumentException | org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            return false;
        }
    }