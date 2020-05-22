/**
 * Takes an image and tilts it by angle. Positive angle implies tilt in
 * clock-wise direction. Negative angle implies in anti-clockwise. Returns
 * null if invalid file.
 *
 *
 * @param image image to be tilted. It assumes that the image is of valid
 * image format and not some random file.
 * @param angle Angle to be rotate clockwise. Ex: Math.PI/2, -Math.PI/4
 * @retun file after tilting angle. Null if not an image
 */
public static File tiltImageByAngle(File image, double angle, BufferedImage original) {
GraphicsConfiguration gc = getDefaultConfiguration();
    BufferedImage rotated1 = tilt(original, angle, gc);
    try {
        //write iamge
        File ans = new File(System.getProperty("java.io.tmpdir")+"temp"+angle+"."+getFileExtension(image.getName())); 
                //new File("temp" + (int) (Math.random() * 100000) + "." + getFileExtension(image.getName()));
        ImageIO.write(rotated1, getFileExtension(image.getName()), ans);
        return ans;
    } catch (IOException ex) {
        ImageRename.LOG.log(Level.SEVERE, null, ex);
        return null;
    }
}