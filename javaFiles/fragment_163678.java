XSSFEventBasedExcelExtractor ext = null;
try {
    ext = new XSSFEventBasedExcelExtractor("C:\\Users\\name\\Desktop\\abc.xlsb");
    System.out.println(ext.getText());

} catch (Exception ex) {
    System.out.println(ex.getMessage());
}