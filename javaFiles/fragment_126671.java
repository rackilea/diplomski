public class Read  {
    public static void main(String[] args) {

        XMLManager.load(new PageProcessor() {
            @Override
            public void process(Page page) {
                // Obviously you want to do something other than just printing, 
                // but I don't know what that is...
                System.out.println(page);
           }
        }) ;
    }

}


public class XMLManager {

    public static void load(PageProcessor processor) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser parser = factory.newSAXParser();
            File file = new File("pages-articles.xml");
            PageHandler pageHandler = new PageHandler(processor);

            parser.parse(file, pageHandler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}