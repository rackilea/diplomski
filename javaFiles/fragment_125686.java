void handle(File inFile, File outFile) throws IOException {    

    Workbook workbook = WorkbookFactory.create(inFile);
    workbook.setMissingCellPolicy(MissingCellPolicy.RETURN_BLANK_AS_NULL);  // LINE NOT REQUIRED

    if (workbook instanceof XSSFWorkbook) {

        handleXSSF((XSSFWorkbook) workbook, outFile);

    } else if (workbook instanceof HSSFWorkbook) {

        handleHSSF((HSSFWorkbook) workbook, outFile);

    } else {

        throw new IOException("Unrecognized Workbook Type " + workbook.getClass().getName());
    }
}

void handleHSSF(HSSFWorkbook hWorkbook, File outFile) throws IOException {

    FileOutputStream fos = null;

    try {

        fos = new FileOutputStream(outFile);    
        hWorkbook.write(fos);
        fos.close();

    } finally {

        try { 

            hWorkbook.close();

        } catch (Exception ignore) {}
    }
}

void handleXSSF(XSSFWorkbook xWorkbook, File outFile) throws IOException {

    SXSSFWorkbook sWorkbook = new SXSSFWorkbook(xWorkbook, 100);

    FileOutputStream fos = null;

    try {

        fos = new FileOutputStream(outFile);    
        sWorkbook.write(fos);
        fos.close();

    } finally {

        try { 

            sWorkbook.close();

        } catch (Exception ignore) {}

        try { 

            sWorkbook.dispose();

        } catch (Exception ignore) {}

        try { 

            xWorkbook.close();

        } catch (Exception ignore) {}
    }
}