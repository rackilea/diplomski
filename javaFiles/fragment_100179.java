private static void save(String fileName, String ext) {

   File file = new File(fileName + "." + ext);
   BufferedImage image = toBufferedImage(file);
try {
   ImageIO.write(image, ext, file);  // ignore returned boolean
} catch(IOException e) {
 System.out.println("Write error for " + file.getPath() +
                               ": " + e.getMessage());
  }
 }