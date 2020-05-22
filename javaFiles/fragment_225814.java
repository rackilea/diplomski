public void should_partial_write() throws Exception {
    // The data to write
    Order mainOrder = new Order();
    mainOrder.setOrderNumber(1);
    mainOrder.setProductNumber(42);
    mainOrder.setUserComment("some comment");
    Order subOorder = new Order();
    subOorder.setOrderNumber(2);
    subOorder.setParentOrder(1);
    subOorder.setProductNumber(43);

    // for testing write to a string rather than a file
    StringWriter outFile = new StringWriter();

    // setup header for the file and processors. Notice the match between the header and the attributes of the
    // objects to write. The rules are that
    // - if optional "parent orders" are absent, write -1
    // - and optional user comments absent are written as ""
    String[] header = new String[] { "orderNumber", "parentOrder", "productNumber", "userComment" };
    CellProcessor[] Processing = new CellProcessor[] { null, new ConvertNullTo(-1), null, new ConvertNullTo("\"\"") };

    // write the partial data
    CsvBeanWriter writer = new CsvBeanWriter(outFile, CsvPreference.EXCEL_PREFERENCE);
    writer.writeHeader(header);
    writer.write(mainOrder, header, Processing);
    writer.write(subOorder, header, Processing);
    writer.close();

    // show output
    System.out.println(outFile.toString());
}