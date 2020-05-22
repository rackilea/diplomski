public class ApachePOI {

    public static void main(final String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Mappe1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        POIXMLProperties props = workbook.getProperties();

        /* Let us set some core properties now */
        POIXMLProperties.CoreProperties coreProp = props.getCoreProperties();
        coreProp.setCreator("Thinktibits"); // set document creator
        coreProp.setDescription("set Metadata using Apache POI / Java");
        coreProp.setCategory("Programming"); // category

        /* Finally, we can set some custom Properies */
        POIXMLProperties.CustomProperties custProp = props.getCustomProperties();
        custProp.addProperty("Author", "Thinktibits");// String
        custProp.addProperty("Year", 2014); // Number Property
        custProp.addProperty("Published", true); // Yes No Property
        custProp.addProperty("Typist", "tika");
        FileOutputStream fos = new FileOutputStream("C:\\Mappe1.xlsx");
        workbook.write(fos);
        fos.close();
    }
}