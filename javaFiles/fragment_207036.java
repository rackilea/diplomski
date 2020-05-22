public class FileRequestEntity implements RequestEntity {

    private File file = null;

    public FileRequestEntity(File file) {
        super();
        this.file = file;
    }

    public boolean isRepeatable() {
        return true;
    }

    public String getContentType() {
        return "text/plain; charset=UTF-8";
    }

    public void writeRequest(OutputStream out) throws IOException {
        InputStream in = new FileInputStream(this.file);
        try {
            int l;
            byte[] buffer = new byte[1024];
            while ((l = in.read(buffer)) != -1) {
                out.write(buffer, 0, l);
            }
        } finally {
            in.close();
        }
    }

    public long getContentLength() {
        return file.length();
    }
}

File myfile = new File("myfile.txt");
PostMethod httppost = new PostMethod("/stuff");
httppost.setRequestEntity(new FileRequestEntity(myfile));