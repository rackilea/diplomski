public class Utils {
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";

/*
 * Get the extension of a file.
 */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    public static String getName(File f) {
        String fname = null;
        String s = f.getName();
        int i = s.length() - s.lastIndexOf('.');
        fname = s.substring(0,s.length()-i);

        return fname;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Utils.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}