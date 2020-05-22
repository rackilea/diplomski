public class xyzExcelExportView extends AbstractExcelView {

    private static final xyzService xyzService = ApplicationContextProvider.getxyzServiceImpl();

    @SuppressWarnings({ "unchecked" })
    protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CurrencyService currencyService = ApplicationContextProvider.getCurrencyService();
        Currency currency = null;
        //set Response
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "Attachment;Filename=\""+"ExcelExport"+"."+"xls" + "\"");
        // Create Sheet.
        HSSFSheet sheet = workbook.createSheet("Software Contract Database");
        // Create Style for sheet.
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        HSSFCellStyle dateStyle = workbook.createCellStyle();       
        HSSFCellStyle datePatternStyle = workbook.createCellStyle();
        HSSFDataFormat format1 = workbook.createDataFormat();
        HSSFCellStyle dataStyle = workbook.createCellStyle();
        HSSFCellStyle numberStyle = workbook.createCellStyle();     
        dateStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        dataStyle.setWrapText(true);
        datePatternStyle.setDataFormat(HSSFDataFormat
                .getBuiltinFormat("d-mmm-yy"));
        numberStyle.setDataFormat(format1.getFormat("#,##0"));
        // Font setting for sheet.
        HSSFFont font = workbook.createFont();
        HSSFPalette palette = workbook.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.LAVENDER.index,
                (byte) 204,  
                (byte) 204,    
                (byte) 255);
        font.setBoldweight((short) 700);
        sheet.setDefaultColumnWidth((short) 30);
        List<Type> dataList = // YOur Data list     
        int currentRow = 0;
        // WRITE ROW FOR HEADER
        HSSFCell header = null;
        for (short i = 0; i < getHeader().size(); i++) {
            header = getCell(sheet, currentRow, i);
            headerStyle.setFillForegroundColor(HSSFColor.LAVENDER.index);
            headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            headerStyle.setFont(font);
            header.setCellStyle(headerStyle);
            setText(header, getxyzHeader().get(i));
        }       

        HSSFRow row = null;
        HSSFCell cellNumber = null;
        HSSFCell cellString = null;
        HSSFCell cellNumberWitnComma = null;
        HSSFCell cellDate = null;

        for(Type xyz : dataList){
                currentRow++;
                short i = 0;
                row = sheet.createRow(currentRow);
                cellNumber = row.createCell(i);
                cellNumber = fillxyzExcelExportCell(xyz.getId() == null ? 0 : xyz.getId(), 1 , cellNumber);
                cellNumber.setCellStyle(dataStyle);

                cellString = row.createCell(++i);
                cellString = fillxyzExcelExportCell(xyz.getStatus() == null ? "" : xyz.getStatus() , 3 , cellString);   
                cellString.setCellStyle(dataStyle); 

                cellString = row.createCell(++i);
                cellString = fillxyzExcelExportCell(xyz.getxyzStatus() , 3 , cellString);   
                cellString.setCellStyle(dataStyle);

                cellString = row.createCell(++i);
                cellString = fillxyzExcelExportCell(xyz.getName() == null ? "" : xyz.getName(), 3 , cellString);
                cellString.setCellStyle(dataStyle);     
            }
        }   
        workbook.write(response.getOutputStream());
    }