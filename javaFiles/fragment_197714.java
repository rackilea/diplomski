@GET
@Path("/endpoint/{resourceName}")
@Produces("application/pdf")
public Response downloadPdfFile(@PathParam("resourceName") String res) throws IOException {
    File sourceFile = new File("directoryPath/"+ res+ ".png");
    if (!sourceFile.exists()) {
        return Response.status(400).entity("resource not exist").build();
    }
        PDDocument document = new PDDocument();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream in = new FileInputStream(sourceFile);
        BufferedImage bimg = ImageIO.read(in);
        float width = bimg.getWidth();
        float height = bimg.getHeight();
        PDPage page = new PDPage(new PDRectangle(width, height));
        document.addPage(page);
        PDImageXObject img = PDImageXObject.createFromFile(sourceFile.getPath(), 
        document);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.drawImage(img, 0, 0);
        contentStream.close();
        in.close();
        document.save(outputStream);
        document.close();
        return Response.ok(outputStream.toByteArray()).build();