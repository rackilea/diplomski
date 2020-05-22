import java.io.File;
import java.io.IOException;

public class FileBlob implements Blob {

    private final File file;

    public FileBlob(File file) {
        super();
        this.file = file;
    }

    @Override
    public byte[] read() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(byte[] data) throws IOException {
        throw new UnsupportedOperationException();
    }
}