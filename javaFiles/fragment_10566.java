CsvParserSettings s = new CsvParserSettings();
    s.setHeaderExtractionEnabled(false);
    CsvRoutines r = new CsvRoutines(s);

    //set headers of input with 3 columns
    s.setHeaders("action" , "id", "name");
    for(Bean b : r.iterate(Bean.class, new StringReader("I,123,Hello\nU,345,Hi"))){
        System.out.println(b);
    }

    //set headers of input with 2 columns
    s.setHeaders("id", "name");
    for(Bean b : r.iterate(Bean.class, new StringReader("123,Hello\n345,Hi"))){
        System.out.println(b);
    }