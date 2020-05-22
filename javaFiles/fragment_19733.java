File xlsxFile = new File(outputFilename);
    if (xlsxFile.exists() && !xlsxFile.isDirectory()) {
        InputStream fileIn = null;
        try {
            fileIn = new BufferedInputStream(new FileInputStream(xlsxFile), 100);
            workbook = new SXSSFWorkbook(new XSSFWorkbook(fileIn), 100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileIn != null) {
                try {
                    fileIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    } else {
        workbook = new SXSSFWorkbook(100);
    }