InputStream is = new FileInputStream(new File(filePath));
                Workbook workbook = StreamingReader.builder()
                        .rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
                        .bufferSize(2048) // buffer size to use when reading InputStream to file (defaults to 1024)
                        .open(is)) {

            Sheet sheet = workbook.getSheetAt(0);