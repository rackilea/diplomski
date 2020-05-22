public class XmlToJava {

    public static void main(String[] args)  {
        try {
            File file = new File("C:\\new.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("XmlEncoding: " + doc.getXmlEncoding());
            System.out.println("InputEncoding: " + doc.getInputEncoding());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}