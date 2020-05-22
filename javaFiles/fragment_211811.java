public static void main(String[] args) throws IOException
{
    String dest = "SO52807807.pdf";

    Map<String, PDActionJavaScript> map = new HashMap<>();
    DecimalFormat DFMM = new DecimalFormat("00");

    try (PDDocument doc = new PDDocument())
    {
        PDDocumentNameDictionary documentNameDictionary = new PDDocumentNameDictionary(doc.getDocumentCatalog());
        PDJavascriptNameTreeNode javascriptNameTreeNode = new PDJavascriptNameTreeNode();
        documentNameDictionary.setJavascript(javascriptNameTreeNode);

        COSDictionary acroFormDict = new COSDictionary();
        acroFormDict
                .setBoolean(COSName.getPDFName("NeedAppearances"), true);
        acroFormDict.setItem(COSName.FIELDS, new COSArray());

        PDAcroForm acroForm = new PDAcroForm(doc, acroFormDict);
        doc.getDocumentCatalog().setAcroForm(acroForm);

        for (int i = 0; i < 4; i++)
        {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDAnnotationAdditionalActions buttonAction1 = null;
            PDActionJavaScript javascript = null;
            PDActionJavaScript tfJs = null;

            String iStr = DFMM.format(i);

            PDFont font = PDType1Font.HELVETICA;
            PDResources resources = new PDResources();
            resources.put(COSName.getPDFName("Helv"), font);
            acroForm.setDefaultResources(resources);

            PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(doc);
            pdAppearanceStream.setResources(resources);

            PDTextField textField = new PDTextField(acroForm);
            textField.setPartialName("SampleField-" + iStr);

            String defaultAppearance = "/Helv 24 Tf 0 0 0 rg";
            textField.setDefaultAppearance(defaultAppearance);

            textField.setMultiline(true);

            acroForm.getFields().add(textField);

            PDAnnotationWidget fieldwidget = textField.getWidgets().get(0);
            PDRectangle rect = new PDRectangle(50, 600, 300, 70);
            fieldwidget.setRectangle(rect);
            fieldwidget.setPage(page);

            textField.setValue("Click to get Date");

            PDAppearanceCharacteristicsDictionary fieldAppearance = new PDAppearanceCharacteristicsDictionary(
                    new COSDictionary());
            fieldAppearance.setBorderColour(new PDColor(
                    new float[]
                    {
                        0, 0, 0
                    }, PDDeviceRGB.INSTANCE));
            fieldAppearance.setBackground(new PDColor(new float[]
            {
                1, 1, 1
            },
                    PDDeviceRGB.INSTANCE));
            fieldwidget.setAppearanceCharacteristics(fieldAppearance);

            fieldwidget.setPrinted(true);

            page.getAnnotations().add(fieldwidget);

            COSDictionary cosDict1 = new COSDictionary();
            COSArray buttonRect1 = new COSArray();
            buttonRect1.add(new COSFloat(50));
            buttonRect1.add(new COSFloat(575));
            buttonRect1.add(new COSFloat(150));
            buttonRect1.add(new COSFloat(550));

            cosDict1.setItem(COSName.RECT, buttonRect1);
            cosDict1.setItem(COSName.FT, COSName.getPDFName("Btn")); // Field
            // Type
            cosDict1.setItem(COSName.TYPE, COSName.ANNOT);
            cosDict1.setItem(COSName.SUBTYPE, COSName.getPDFName("Widget"));
            cosDict1.setItem(COSName.T, new COSString("Datum anzeigen"));
            cosDict1.setItem(COSName.DA,
                    new COSString("/F0 6 Tf 0 g 1 1 1 rg "));

            PDPushButton button1 = new PDPushButton(acroForm);
            javascript = new PDActionJavaScript("function date" + iStr
                    + "() {var fld" + iStr + " = this.getField('SampleField-"
                    + iStr + "'); fld" + iStr
                    + ".value = util.printd('dd mmmm yyyy',new Date());}");

            //doc.getDocumentCatalog().setOpenAction(javascript);
            map.put("date" + iStr, javascript);

            tfJs = new PDActionJavaScript("date" + iStr + "();");
            buttonAction1 = new PDAnnotationAdditionalActions();

            buttonAction1.setU(tfJs);
            button1.getWidgets().get(0).setActions(buttonAction1);

            button1.getCOSObject().addAll(cosDict1);
            acroForm.getFields().add(button1);

            PDAnnotationWidget buttonWidget1 = button1.getWidgets().get(0);

            PDAppearanceCharacteristicsDictionary buttonFieldAppearance = new PDAppearanceCharacteristicsDictionary(
                    new COSDictionary());
            COSArray borderColorArray = new COSArray();
            borderColorArray.add(new COSFloat((float) (141f / 255f)));
            borderColorArray.add(new COSFloat((float) (179f / 255f)));
            borderColorArray.add(new COSFloat((float) (226f / 255f)));
            PDColor blue = new PDColor(borderColorArray, PDDeviceRGB.INSTANCE);
            buttonFieldAppearance.setBorderColour(blue);
            buttonFieldAppearance.setBackground(blue);
            buttonFieldAppearance.setNormalCaption("Felder löschen");

            buttonWidget1.setAppearanceCharacteristics(buttonFieldAppearance);
            page.getAnnotations().add(buttonWidget1);

        }
        javascriptNameTreeNode.setNames(map);
        doc.getDocumentCatalog().setNames(documentNameDictionary);
        File file = new File(dest);
        file.getParentFile().mkdirs();
        doc.save(dest);
    }
}