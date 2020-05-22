private void drawImageOnExcelSheetForGLOS(XSSFSheet sitePhotosSheet,
        int row1, int row2, int col1, int col2, String fileName) {
    try {

        InputStream is = new FileInputStream(fileName);
        byte[] bytes = IOUtils.toByteArray(is);
        int pictureIdx = sitePhotosSheet.getWorkbook().addPicture(bytes,Workbook.PICTURE_TYPE_JPEG);
        is.close();
        CreationHelper helper = sitePhotosSheet.getWorkbook().getCreationHelper();

        XSSFDrawing drawing = sitePhotosSheet.createDrawingPatriarch();

        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setAnchorType( ClientAnchor.MOVE_AND_RESIZE );

        anchor.setCol1(col1);
        anchor.setCol2(col2);
        anchor.setRow1(row1);
        anchor.setRow2(row2);

        // setLineXXX() methods can be used to set line border to image
        XSSFPicture pic = drawing.createPicture(anchor, pictureIdx);
        // 0 indicates solid line
        pic.setLineStyle(0);
        // rgb color code for black line
        pic.setLineStyleColor(0, 0, 0);
        // double number for line width
        pic.setLineWidth(1.5);
    } catch(Exception e) {
        e.printStackTrace();
    }
}