public class ChangeCellFontName {  
        public static void main(String[] args) throws Exception{

                /* Create Workbook and Worksheet */
                HSSFWorkbook my_workbook = new HSSFWorkbook();
                HSSFSheet my_sheet = my_workbook.createSheet("Cell Font");

                /* Get access to HSSFCellStyle */
                HSSFCellStyle my_style = my_workbook.createCellStyle();

                /* Create HSSFFont object from the workbook */
                HSSFFont my_font=my_workbook.createFont();

                /* Set the font name to Verdana */
                my_font.setFontName("Verdana");

                /* Also make the font color to RED */
                my_font.setColor(HSSFFont.COLOR_RED);

                /* attach the font to the style created earlier */
                my_style.setFont(my_font);

                /* Attach the new font to a cell */
                /* Create a row in the sheet */
                Row row = my_sheet.createRow(0);

                /* Create a cell */
                Cell cell = row.createCell(0);
                cell.setCellValue("The font for this text would be Verdana");

                /* Attach the style to the cell */
                cell.setCellStyle(my_style);


        }
}