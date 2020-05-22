public void generateSpreadsheet() {

    Workbook wb = new XSSFWorkbook();
    XSSFSheet sheet1 = null;
    HttpSession session = ServletUtil.getInstance().getSession();
    String pngImageURL = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQAAAAEACAYAAABccqhmAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAFNRSURBVHja7L0HnCRHeT78VPekzeHu9nLQnbJAFgpYmE8SCBDgP8kEG8xnG2QbPmP4/wBjcsZIQgIhMAKLIMkSCAWQUEAo350Ckk66ky7nvb3d29scZ3Zid9dX1Ttzmp3tUB1mdma361Tq3NPb/T5Pve9bb71FKKUISlCCsjCLFLyCoAQlIICgBCUoAQEEJShBWUglFLyChVM+9DyRm0IdEY1qEVXLRRQ1JymaArZONcr/QxasUg25uy+lavDG5n8hgROw9st/97x/MfuUqyQqLVGpulTT1GZFy7XmtGy9QjOxrJppULRMOKumwzktE+NVUbNsPScrWlZi64qiqTkG/gwThySrU/n1NFsm+HZ+3xgjh0m2PszWx/nygXfQyeALBAQQlDKX/x38eLhOajqFUHmNTELrQKVV7PMtB2gHAzurmdaslmpitS6jJaMZNRVh6zIDOxjwwY6DEQL4dk7Jsu0cq1nW+itsXw4aW3IVQBcHVvWlNr3M71PYMpUnggm2HGLL42zZw2ofW+9jywG2HOTEwOrgQ+8NtIiAAILiuNw//q0IW5xbJ7WcFyENZ8gIr...";//data-uri

    sheet1 = (XSSFSheet) wb.createSheet("ExcelName");

    //Method1 for data-uri using org.apache.commons.codec.binary.Base64 library
    String encodingPrefix = "base64,";
    int contentStartIndex = pngImageURL.indexOf(encodingPrefix) + encodingPrefix.length();
    byte[] imageData1 = org.apache.commons.codec.binary.Base64.decodeBase64(pngImageURL.substring(contentStartIndex));//workbook.addPicture can use this byte array

    //Alternate Method2 for data-uri using javax.xml.bind 
    // Read from a Data URL
    byte[] imagedata2 = DatatypeConverter.parseBase64Binary(pngImageURL.substring(contentStartIndex)); //workbook.addPicture can use this byte array

    //Alternate Method3 for Image File using FileInputStream
    try {
        InputStream is = new FileInputStream("C://Users//Desktop//downloadpngImage.png");
        byte[] bytes = IOUtils.toByteArray(is);//workbook.addPicture can use this byte array
        } catch (FileNotFoundException e) {}
        catch (IOException e) {}

    //code for adding image to excel starts
    int pictureIdx = wb.addPicture(imageData1, wb.PICTURE_TYPE_PNG);

    // Create the drawing patriarch. This is the top level container for all shapes. 
    Drawing drawing = sheet1.createDrawingPatriarch();

    //add a picture shape
    CreationHelper helper = wb.getCreationHelper();
    ClientAnchor anchor = helper.createClientAnchor();
    //set top-left corner of the picture,
    //subsequent call of Picture#resize() will operate relative to it
    anchor.setCol1(2);
    anchor.setCol2(3);
    anchor.setRow1(3);
    anchor.setRow2(4);

    Picture pict = drawing.createPicture(anchor, pictureIdx);

    //auto-size picture relative to its top-left corner
    pict.resize();
}