String str = "value1, value2, value3, value4, \"value5, 1234\", " +
        "value6, value7, \"value8\", value9, \"value10, 123.23\"";

CSVReader reader = new CSVReader(new StringReader(str));

String [] tokens;
while ((tokens = reader.readNext()) != null) {
    System.out.println(tokens[0]); // value1
    System.out.println(tokens[4]); // value5, 1234
    System.out.println(tokens[9]); // value10, 123.23
}