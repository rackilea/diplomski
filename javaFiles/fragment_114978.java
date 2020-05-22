public class NewFileOnRebootAppender extends FileAppender {

    public NewFileOnRebootAppender() {
    }

    @Override
    public void setFile(String file) {
        super.setFile(prependDate(file));
    }

    private static String prependDate(String filename) {
        return System.currentTimeMillis() + "_" + filename;
    }
}