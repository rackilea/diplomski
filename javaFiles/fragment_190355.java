import java.io.*;
import java.util.*;
import javax.activation.*;
import javax.xml.bind.attachment.AttachmentUnmarshaller;

public class MyAttachmentUnmarshaller extends AttachmentUnmarshaller {

    private Map<String, byte[]> attachments = new HashMap<String, byte[]>();

    public Map<String, byte[]> getAttachments() {
        return attachments;
    }

    @Override
    public DataHandler getAttachmentAsDataHandler(String cid) {
        byte[] bytes = attachments.get(cid);
        return new DataHandler(new ByteArrayDataSource(bytes));
    }

    @Override
    public byte[] getAttachmentAsByteArray(String cid) {
        return attachments.get(cid);
    }

    @Override
    public boolean isXOPPackage() {
        return true;
    }

    private static class ByteArrayDataSource implements DataSource {

        private byte[] bytes;

        public ByteArrayDataSource(byte[] bytes) {
            this.bytes = bytes;
        }

        public String getContentType() {
            return  "application/octet-stream";
        }

        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(bytes);
        }

        public String getName() {
            return null;
        }

        public OutputStream getOutputStream() throws IOException {
            return null;
        }

    }

}