import com.monitorjbl.xlsx.StreamingReader;

InputStream is = new FileInputStream(new File("/path/to/workbook.xlsx"));
Workbook workbook = StreamingReader.builder()
    .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
    .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
    .open(is);            // InputStream or File for XLSX file (required)