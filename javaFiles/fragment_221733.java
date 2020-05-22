//let's write to a String to make this easy to test
    StringWriter out = new StringWriter();

    CsvWriterSettings settings = new CsvWriterSettings();
    //set headers
    settings.setHeaders("a", "b", "c");
    //automatically write headers when the first data row is written
    settings.setHeaderWritingEnabled(true);

    CsvWriter writer = new CsvWriter(out, settings);
    //write comment
    writer.commentRow("lalala");

    //write data rows
    writer.writeRow("1", "3", "6");
    writer.writeRow("3", "1", "1");

    writer.close();

    //print output
    System.out.println(out);