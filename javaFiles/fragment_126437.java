if(xlFile.exists() && !xlFile.isDirectory())
    xlFile.delete(); //delete if file already exists.
xlFile.createNewFile();

inStream = new FileInputStream(xlFile);          
workbook =  WorkbookFactory.create(inStream);