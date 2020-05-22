import java.io.IOException;

public interface Blob {
    public byte[] read() throws IOException;
    public void update(byte[] data) throws IOException;
}