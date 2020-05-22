PdfReader reader = new PdfReader(src);
int pageILikeToCheck =reader.getNumberOfPages(); //set the page or loop them all        
final String matchStr = "FIND THIS TEXT";

PdfReaderContentParser parser = new PdfReaderContentParser(reader);
parser.processContent(pageILikeToCheck, new RenderListener() {  

    @Override
    public void renderImage(ImageRenderInfo renderInfo) {
        PdfImageObject image;
        try {
            image = renderInfo.getImage();
            if (image == null) return;
            System.out.println("Found image");
            System.out.println(renderInfo.getStartPoint());
        } catch (IOException e) {
            e.printStackTrace();
        }     
    }

    @Override
    public void renderText(TextRenderInfo renderInfo) {

        if(renderInfo.getText().length()>0 && matchStr.contains(renderInfo.getText())){
            System.out.println("FOUND MY TEXT");
            System.out.println(renderInfo.getBaseline().getStartPoint());
            System.out.println(renderInfo.getBaseline().getEndPoint());
        }
    }

    @Override
    public void endTextBlock() {
    }

    @Override
    public void beginTextBlock() {
    }
});