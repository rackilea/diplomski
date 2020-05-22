String input_DOCX = System.getProperty("user.dir") + "/some.docx";

    // resulting docx
    String OUTPUT_DOCX = System.getProperty("user.dir") + "/OUT_ContentControlRemove.docx";

    // Load input_template.docx
    WordprocessingMLPackage wordMLPackage = Docx4J.load(new File(input_DOCX));

    // There is no xml stream
    FileInputStream xmlStream = null;

    Docx4J.bind(wordMLPackage, xmlStream, Docx4J.FLAG_BIND_REMOVE_SDT);

    //Save the document 
    Docx4J.save(wordMLPackage, new File(OUTPUT_DOCX), Docx4J.FLAG_NONE);