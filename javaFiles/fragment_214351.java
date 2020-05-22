@Configuration
public class PdfExtractServerConfig {

    @Bean
    public PdfExtractServer pdfExtractServer() {
       final PdfExtractServer pdfExtractServer = new PdfExtractServer();
       pdfExtractServer.start("PES");
       return pdfExtractServer
    }
}