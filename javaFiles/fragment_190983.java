public static void captureScreenShot() throws Exception {
    XWPFDocument docx = new XWPFDocument();
    XWPFParagraph paragraph = docx.createParagraph();    
    XWPFRun run = paragraph.createRun();
    String screenshot_name = System.currentTimeMillis() + ".png";
    BufferedImage image = new Robot()
            .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    ImageIO.write(image, "png", new File("d:/xyz/" + screenshot_name));
    InputStream pic = new FileInputStream("d:/xyz/" + screenshot_name);
    //docx.addPictureData(pic, Document.PICTURE_TYPE_PNG);
    run.addBreak();
    run.addPicture(pic, XWPFDocument.PICTURE_TYPE_JPEG, screenshot_name, Units.toEMU(350), Units.toEMU(350));
    pic.close();
    FileOutputStream out = new FileOutputStream("d:/xyz/doc1.docx");
    docx.write(out);
    out.flush();
    out.close();

    TimeUnit.SECONDS.sleep(1);
}