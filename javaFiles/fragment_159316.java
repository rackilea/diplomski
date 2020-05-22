import java.io.Closeable;
import java.io.IOException;

public interface LineReader2 extends Closeable 
{
    void close() throws IOException;
    String readLine() throws IOException; 
}