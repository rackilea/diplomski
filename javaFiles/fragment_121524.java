public class RenderImages {
private static final Log log = LogFactory.getLog(RenderImages.class);

public static void generateRenderedImages(Datastore datastore,
    InputStream inputStream,
    String fileName,
    ConversionHandler conversionHandler,
    SystemProperties systemProperties,
    Logger logger) {

    int thumbnailHeight = systemProperties.getAsInteger("RENDER_THUMBNAIL_HEIGHT");
    int thumbnailWidth = systemProperties.getAsInteger("RENDER_THUMBNAIL_WIDTH");
    String contentTypePreview = systemProperties.get("RENDER_CONTENT_TYPE_PREVIEW");
    String contentTypeThumbnail = systemProperties.get("RENDER_CONTENT_TYPE_THUMBNAIL");

    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, outputStream);
        byte[] imageBytes = outputStream.toByteArray();
        inputStream.close();

        ImageSaveOptions imageSaveOptions = new ImageSaveOptions();
        imageSaveOptions.setSaveFileType(ImageSaveOptions.JPEG);
        imageSaveOptions.setPage(1);

        ByteArrayOutputStream previewStream = conversionHandler.convertToImage(new ByteArrayInputStream(imageBytes),
            fileName + ".pdf",
            imageSaveOptions);

        saveToDatabase(datastore, previewStream, contentTypePreview, fileName);
        previewStream.close();

        imageSaveOptions.setHeight(thumbnailHeight);
        imageSaveOptions.setWidth(thumbnailWidth);

        ByteArrayOutputStream thumbnailStream = conversionHandler.convertToImage(
            new ByteArrayInputStream(imageBytes),
            fileName + ".pdf",
            imageSaveOptions);

        saveToDatabase(datastore, thumbnailStream, contentTypeThumbnail, fileName);
        thumbnailStream.close();
    } catch (Exception e) {
        e.printStackTrace();
        log.error("Image rendering failed); error = " + e.getMessage());
        logger.writeLog("Image rendering failed); error = " + e.getMessage());

    } finally {
        // maybe need something here, not sure yet
    }
}

private static void saveToDatabase(Datastore datastore,
    ByteArrayOutputStream image, String contentType, String fileName) throws IOException {

    RenderedImage renderedImage = datastore.find(RenderedImage.class)
        .filter("attachmentId", fileName)
        .filter("contentType", contentType)
        .get();

    if (renderedImage == null) {
        renderedImage = new RenderedImage();
        renderedImage.setAttachmentId(fileName);
        renderedImage.setContentType(contentType);
        renderedImage.setContent(image.toByteArray());
        datastore.save(renderedImage);
    }
}