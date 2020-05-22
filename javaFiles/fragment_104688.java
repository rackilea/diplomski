public class StreamResourceReader implements ResourceReader {

private HttpServletResponse response;

public StreamResourceReader(HttpServletResponse response) {
    this.response = response;
}

@Override
public void read(InputStream content) {
    try {
        IOUtils.copy(content, response.getOutputStream());
    } catch (IOException e) {
        throw new IllegalStateException(e);
    }
}
}