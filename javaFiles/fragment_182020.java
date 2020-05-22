public class ImageFilter extends FileFilter {

    //Accept all directories and all jpeg, jpg files with lossy in its filename.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        String filename = Utils.getName(f);
        if (extension != null) {
            if ((extension.equals(Utils.jpeg) || extension.equals(Utils.jpg)) && filename.contains("lossy")) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Images (Lossy)";
    }
}