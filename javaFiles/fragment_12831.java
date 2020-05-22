public class KnownFileHandler extends StreamHandler {

    private final File file;

    public KnownFileHandler() throws IOException {
        String v = LogManager.getLogManager().getProperty(getClass().getName() +".name");
        if(v == null) {
            v = "knownfilehandler.log";
        }
        file = new File(v);
        this.setOutputStream(new FileOutputStream(file));
    }


    public File getFile() {
        return this.file;
    }
}