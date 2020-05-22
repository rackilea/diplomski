public class FileItemDataSource implements DataSource {

    private FileItem item;

    public FileItemDataSource(FileItem item) {
        this.item = item;
    }

    @Override
    public String getContentType() {
        return item.getContentType() ;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return item.getInputStream();
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return item.getOutputStream();
    }
}