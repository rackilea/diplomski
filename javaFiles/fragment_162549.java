@SpringBootApplication
public class SvgManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SvgManagerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {      

        try {
        Resource svg = new ClassPathResource("icons/128/black/ae.png"); 
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
            Document doc = f.createDocument(SVG_DOCUMENT_URI, svg.getInputStream());

            System.out.println(doc);

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }
    }
}