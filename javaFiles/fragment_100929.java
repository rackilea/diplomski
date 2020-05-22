public JasperDesign getJasperDesign() throws JRException {
    JasperDesign jasperDesign = new JasperDesign();
    jasperDesign.setName(DESIGN_NAME);
    jasperDesign.setPageWidth(595);
    jasperDesign.setPageHeight(842);
    jasperDesign.setColumnWidth(515);
    jasperDesign.setColumnSpacing(0);
    jasperDesign.setLeftMargin(40);
    jasperDesign.setRightMargin(40);
    jasperDesign.setTopMargin(50);
    jasperDesign.setBottomMargin(50);

    JRDesignParameter parameter = new JRDesignParameter();
    parameter.setName("ReportTitle");
    parameter.setValueClass(java.lang.String.class);
    jasperDesign.addParameter(parameter);

    //Title band
    JRDesignBand band = new JRDesignBand();
    band.setHeight(250);

    JRDesignTextField textField = new JRDesignTextField();
    textField.setBlankWhenNull(true);
    textField.setX(0);
    textField.setY(10);
    textField.setWidth(515);
    textField.setHeight(30);
    textField.setHorizontalAlignment(HorizontalAlignEnum.CENTER);
    textField.setFontSize(22);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{ReportTitle}");
    textField.setExpression(expression);
    band.addElement(textField);

    // Image
    String imgPath = "\"dukesign.jpg\"";

    expression = new JRDesignExpression();
    expression.setText(imgPath);

    JRDesignImage image = new JRDesignImage(jasperDesign);
    image.setX(45);
    image.setY(55);
    image.setWidth(130);
    image.setHeight(104);
    image.setScaleImage(ScaleImageEnum.FILL_FRAME);
    image.setExpression(expression);

    // Add image to Detail band
    band.addElement(image);

    jasperDesign.setTitle(band);

    return jasperDesign;
}