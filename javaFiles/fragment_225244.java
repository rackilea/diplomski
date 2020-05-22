File outputfile = new File("saved.tif");

if (!ImageIO.write(result, "TIFF", outputfile)) {
    // Beware, write is a boolean method, that returns success!
    System.err.println("Could not write " + outputfile.getAbsolutePath() + " in TIFF format.");
}