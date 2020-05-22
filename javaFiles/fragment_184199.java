public static void main(String[] args) throws JRException {

    JasperDesign design = JRXmlLoader.load("jasper/testJasperDesign.jrxml");
    JRBand titleBand = design.getTitle();
    JRElement[] elements = titleBand.getElements();
    for (JRElement element : elements) {
        if (element instanceof JRDesignTextField){
            JRDesignTextField textField = (JRDesignTextField) element;
            JRExpression expression = textField.getExpression();
            System.out.println(expression.getText());
        }
        if (element instanceof JRDesignStaticText){
            JRDesignStaticText staticText = (JRDesignStaticText) element;
            System.out.println(staticText.getText());
        }

    }
}