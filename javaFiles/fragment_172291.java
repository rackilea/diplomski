PDAnnotationWidget widget = button.getWidgets().get(0);
    PDAppearanceDictionary appearanceDictionary = new PDAppearanceDictionary();
    PDAppearanceStream appearanceStream = new PDAppearanceStream(doc);
    appearanceStream.setResources(new PDResources());
    try (PDPageContentStream cs = new PDPageContentStream(doc, appearanceStream))
    {
        PDRectangle bbox = new PDRectangle(widget.getRectangle().getWidth(), widget.getRectangle().getHeight());
        appearanceStream.setBBox(bbox);
        cs.setNonStrokingColor(0, 0, 0); // black
        cs.addRect(bbox.getLowerLeftX() + 0.5f, bbox.getLowerLeftY() + 0.5f, bbox.getWidth() - 1, bbox.getHeight() - 1);
        cs.stroke();

        // put some useful text
        cs.setFont(PDType1Font.HELVETICA, 20);
        cs.beginText();
        cs.newLineAtOffset(20, 20);
        cs.showText("Close");
        cs.endText();
    }
    appearanceDictionary.setNormalAppearance(appearanceStream);
    widget.setAppearance(appearanceDictionary);