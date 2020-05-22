import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.StatusLine;
import org.apache.commons.httpclient.methods.PostMethod;

public class Main {
    public static void main(String[] args) throws Exception {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PostMethod method = new PostMethod () {
            @Override
            protected void readResponse(HttpState state, HttpConnection conn)
                    throws IOException, HttpException {
                statusLine = new StatusLine ("HTTP/1.1 200 OK");
            }
        };
        method.addParameter("aa", "b");

        method.execute(new HttpState (), new HttpConnection("http://www.google.abc/hi", 80) {

            @Override
            public void flushRequestOutputStream() throws IOException {
            }

            @Override
            public OutputStream getRequestOutputStream() throws IOException,
                    IllegalStateException {
                return baos;
            }

            @Override
            public void write(byte[] data) throws IOException,
                    IllegalStateException {
                baos.write(data);
            }

        });

        final String postBody = new String (baos.toByteArray());

        System.out.println(postBody);
    }
}