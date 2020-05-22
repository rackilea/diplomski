public void generateImages(final String sourcePath) {  
     try {  
         Workbook workbook = new Workbook(sourcePath);  
         List<Worksheet> worksheets = getAllWorksheets(workbook);  
         if (worksheets != null) {  
             int noOfImages = 0;  
             for (Worksheet worksheet : worksheets) {  
                 if (worksheet.getCells().getCount() > 0 || worksheet.getCharts().getCount() > 0 || worksheet.getPictures().getCount() > 0) {  
                     String imageFilePath = sourcePath + "_output_" + (noOfImages++) + ".jpeg";   
                     SheetRender sr = new SheetRender(worksheet, getImageOrPrintOptions());  
                     sr.toImage(0, imageFilePath);  
                 }  
             }  
         }  
     } catch (Exception e) {  
         e.printStackTrace();  
     }  
 }  
 /**  
  * Returns all worksheets present in given workbook.  
  *   
  * @param workbook  
  * @return all worksheets present in given workbook.  
  */  
 private List<Worksheet> getAllWorksheets(final Workbook workbook) {  
     List<Worksheet> worksheets = new ArrayList<Worksheet>();  
     WorksheetCollection worksheetCollection = workbook.getWorksheets();  
     for (int i = 0; i < worksheetCollection.getCount(); i++) {  
         worksheets.add(worksheetCollection.get(i));  
     }  
     return worksheets;  
 }  
 /**  
  * Returns ImageOrPrintOptions for png images  
  *   
  * @return  
  */  
 private ImageOrPrintOptions getImageOrPrintOptions() {  
     ImageOrPrintOptions imgOptions = new ImageOrPrintOptions();  
     imgOptions.setImageFormat(ImageFormat.getJpeg());  
     imgOptions.setOnePagePerSheet(true);  
     return imgOptions;  
 }