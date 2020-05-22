class Example {

    static ConversionAlgorithm xmlTojson = new JSONConverter();
    static ConversionAlgorithm xmlTocsv = new CSVConverter();

    public static void main(String[] args) {

        File xml = ... // get it somehow
        Converter converter = new Converter(xml);
        converter.setConversionAlgorithm(xmlTojson);
        File json = converter.convert();
        converter.setConversionAlgorithm(xmlTocsv);
        File csv = converter.convert();
    }
}