JasperDesign design = JRXmlLoader.load("path/to/your/JRXML.file");
JRElement element;
for (JRBand band : design.getDetailSection().getBands()) {
    element band.getElementByKey("elementName");
}
if (element != null) {
    ((JRDesignTextElement) element).setFontName("Arial");
}