public static void main(String[] args) throws IOException, InvalidFormatException {

    // Create the destination file and folder structure
    File destfile = new File("C:\\Evidences\\test\\imgdocx.docx");
    destfile.getParentFile().mkdirs();
    destfile.createNewFile();

    // Create the docx object
    XWPFDocument doc = new XWPFDocument();

    // Get the source folder and list of files (includes images and
    // sub-folders)
    File srcfile = new File("C:\\reports\\test\\images");
    File[] list = srcfile.listFiles();
    System.out.println("Source folder item list " + list.length);

    // Iterate through the files in the source folder
    for (int k = 0; k < list.length; k++) {
        if (list[k].isFile()) {
            System.out.println("File - " + list[k].getName());

            // Create paragraph
            XWPFParagraph p = doc.createParagraph();
            XWPFRun r = p.createRun();

            // Create fis for image
            FileInputStream fis = new FileInputStream(list[k].getPath());
            // add image using the fis
            r.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG,
                    list[k].getPath(),
                    Units.toEMU(200), Units.toEMU(200));
            fis.close();

        } else if (list[k].isDirectory()) {
            System.out.println("Directory - " + list[k].getName());
            // If directory do nothing
            // A recursive logic can be implemented to handle the files
            // inside folders in source folder
        }
    }

    // write docx to destination file
    FileOutputStream fos = new FileOutputStream(destfile);
    doc.write(fos);
    fos.close();
    doc.close();
}