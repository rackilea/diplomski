// Spring will by default scan after this annotation recursively through
// packages on classes and create by default a singleton. It will also 
// search after all bean dependencies that need to be injected. in this case 
// PdfExtracServer and then inject it.
@Component 
public class Foo {

    @Autowire
    private PdfExtractServer pdfExtractServer;

    //different methods here

}