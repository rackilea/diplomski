public void convertPPTToPDF(String Path) throws Exception
{
    String extension = "";
    Integer index = Path.lastIndexOf(".");
    if (index > 0) {
        extension = Path.substring(index+1);
    }

    if (extension.equals("ppt"))
    {
        Presentation pres = new Presentation(Path);
        String destPath=Path.substring(0, index)+".pdf";
        pres.saveToPdf(destPath);
    }
    else if (extension.equals("pptx"))
    {
        //Instantiate a PresentationEx object that represents a PPTX file
        PresentationEx pres = new PresentationEx(Path);
        String destPath=Path.substring(0, index)+".pdf";

        //Saving the PPTX presentation to PDF document
        pres.save(destPath, com.aspose.slides.SaveFormat.Pdf);
    }
    System.out.println("Powerpoint file converted to PDF successfully");
}

public void convertExcelToPDF(String Path) throws Exception
{
    String extension = "";
    Integer index = Path.lastIndexOf(".");
    if (index > 0) {
        extension = Path.substring(index+1);
    }

    if (extension.equals("xls"))
    {
        Workbook workbook = new Workbook(Path);

        //Save the document in PDF format
        String destPath=Path.substring(0, index)+".pdf";
        workbook.save(destPath, FileFormatType.PDF);
    }
    else if (extension.equals("xlsx"))
    {
        //Createing and XLSX LoadOptions object
        LoadOptions loadOptions = new LoadOptions(FileFormatType.XLSX);

        //Creating an Workbook object with 2007 xlsx file path and the loadOptions object
        Workbook workbook = new Workbook(Path, loadOptions);
        String destPath=Path.substring(0, index)+".pdf";
        workbook.save(destPath, FileFormatType.PDF);
    }

    System.out.println("Excel file converted to PDF successfully");
}