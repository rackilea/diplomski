class FolderServiceImpl {
    private static final Logger L = LoggerFactory.getLogger(FolderServiceImpl.class);
    private final ReaderFactory readerFactory;

    FolderServiceImpl(ReaderFactory readerFactory) {
        this.readerFactory = readerFactory;
    }

    public int getStatus(String folderPath) {
        int status = 0;
        File folderStatusFile = new File(folderPath, ".folderstatus");
        // try "with resource" takes care of closing the reader
        try (BufferedReader br = readerFactory.createFor(folderStatusFile);) {
            String line = br.readLine();
            status = Integer.parseInt(line);
        } catch (IOException e) {
            status = 3;
        } catch (Exception e) {
            L.error("can't read file " + folderStatusFile.getAbsolutePath(), e);
            status = 4;
        }
        return status;
    }
}