public class TikaBasedFileTypeDetector {
    private Tika tika;
    private TemporaryResources temporaryResources;

    public void init() {
        this.tika = new Tika();
        this.temporaryResources = new TemporaryResources();
    }

    // clean up all the temporary resources
    public void destroy() throws IOException {
        temporaryResources.close();
    }

    // return content mime type
    public String detectType(InputStream in) throws IOException {
        TikaInputStream tikaInputStream = TikaInputStream.get(in, temporaryResources);

        return tika.detect(tikaInputStream);
    }

    public boolean isExcelFile(InputStream in) throws IOException{
        // see https://stackoverflow.com/a/4212908/1700467 for information on mimetypes
        String type = detectType(in);
        return type.startsWith("application/vnd.ms-excel") || //for Micorsoft document
                type.startsWith("application/vnd.openxmlformats-officedocument.spreadsheetml"); // for OpenOffice xml format
    }
}