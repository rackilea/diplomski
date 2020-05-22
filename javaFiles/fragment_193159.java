public class HtmlToPdf {
    public static final String DEST = "/home/christian/Desktop/testDoc.pdf";

    public void createPdf(String file) throws IOException, DocumentException {
        // step 1
        Document document = new Document();

        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        writer.setInitialLeading(12.5f);

        // step 3
        document.open();

        // step 4

        // CSS
        CSSResolver cssResolver = new StyleAttrCSSResolver();
        // CssFile cssFile = XMLWorkerHelper.getCSS(new FileInputStream(CSS));
        // cssResolver.addCss(cssFile);

        // HTML
        XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        fontProvider.register("fonts/Arimo-Regular.ttf");
        fontProvider.register("fonts/Arimo-Bold.ttf");
        fontProvider.register("fonts/Arimo-Italic.ttf");
        fontProvider.addFontSubstitute("lowagie", "Arimo");
        CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

        // Pipelines
        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

        // XML Worker
        XMLWorker worker = new XMLWorker(css, true);
        XMLParser p = new XMLParser(worker);

        // p.parse(new FileInputStream(HTML));
        String htmlContent = " HERE GOES HTML CODE ";
        p.parse(new StringReader(htmlContent));
        // step 5
        document.close();
    }

    public static void main(String[] args) throws IOException, DocumentException {
        new D06_ParseHtmlFonts().createPdf(DEST);
    }
}