private void createAndSavePdfWithImages(String dest, String content) throws Exception {
        OutputStream file = new FileOutputStream(new File(dest));
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, file);
        document.open();

        byte[] bytes = content.getBytes( Charset.forName("UTF-8"));
        InputStream is = new ByteArrayInputStream(bytes);

        CssFilesImpl cssFiles = new CssFilesImpl();
        InputStream inCssFile = servletContext.getResourceAsStream("/css/doc_template.css");
        CSSResolver cssResolver = null;
        if(inCssFile != null) {
            cssFiles.add(XMLWorkerHelper.getInstance().getCSS(inCssFile));
            cssResolver = new StyleAttrCSSResolver(cssFiles);
        } else {
            cssResolver  = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
        }

        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        htmlContext.setImageProvider(new ImageProvider());

        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

        XMLWorker worker = new XMLWorker(css, true);
        XMLParser p = new XMLParser(worker);
        p.parse(is, Charset.forName("UTF-8"));

        document.close();
    }

    class ImageProvider extends AbstractImageProvider {

        @Override
        public Image retrieve(String src) {
            try {
                String path = servletContext.getRealPath(src);
                Image img = com.itextpdf.text.Image.getInstance(path);
                return Image.getInstance(img);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public String getImageRootPath() {
            return null;
        }
    }