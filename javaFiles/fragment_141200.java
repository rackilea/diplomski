public static boolean generatePreviewImage(String filePath,
        String previewFileName) throws IOException, Exception {
    logger.info("Request received to generate thumbnail for video. VideoFilePath : "
            + filePath + ", resultFileName " + previewFileName);
    boolean isPreviewGenerated = false;
    FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(filePath);
    logger.info("FrameGrabber found " + grabber);
    grabber.start();
    logger.info("FrameGrabber started.. " + grabber);
    for (int i = 20; i < 22; i++) {
        logger.info("Reading first 2 images..");
        ImageIO.write(grabber.grab().getBufferedImage(), "jpg", new File(
                previewFileName + "_" + i));
        logger.info(i + " image written successfully as " + previewFileName
                + "_" + i + ".jpg");
        isPreviewGenerated = true;
    }
    grabber.stop();
    logger.info("Is preview generated.." + isPreviewGenerated);
    return isPreviewGenerated;

}