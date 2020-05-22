// Credit to Mihai. Code found here: http://stackoverflow.com/questions/6851385/save-tiff-ccittfaxdecode-from-pdf-page-using-itext-and-java
public static ArrayList<BufferedImage> getBufImgArr(final String BasePath) throws IOException {

    PdfReader reader = new PdfReader(BasePath);
    PdfReaderContentParser parser = new PdfReaderContentParser(reader);
    MyImageRenderListener listener = new MyImageRenderListener(BasePath + "extract/image%s.%s");

    for (int page = 1; page <= reader.getNumberOfPages(); page++) {
        parser.processContent(page, listener);
    }

    reader.close();
    return listener.getBimgArray();

}