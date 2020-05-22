outputStream = response.getOutputStream();

        XHTMLImporter.setHyperlinkStyle("Hyperlink");

        // Create an empty docx package
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

        NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
        wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
        ndp.unmarshalDefaultNumbering();

        // Convert the XHTML, and add it into the empty docx we made
        List<Object> wmlObjects = getWmlObjects(wordMLPackage, xhtmlDocumentAsString);
        wordMLPackage.getMainDocumentPart().getContent().addAll(wmlObjects);

        SaveToZipFile saver = new SaveToZipFile(wordMLPackage);
        saver.save(outputStream);