public class MyUtilities {

    public static FileChooser createFileChooser() {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File(System.getProperty("user.home"));
        return chooser ;
    }
}