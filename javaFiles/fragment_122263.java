CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(System.out),
        ',', '\0', '\0');
csvWriter.writeNext(new String[] { "\"Header 1\"", "\"Header 2\"",
        "\"Header 3\"" });
csvWriter.writeNext(new String[] { "123.4", "234.6", "999.8" });
csvWriter.close();