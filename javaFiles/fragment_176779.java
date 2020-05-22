import java.io.DataInput;
    import java.io.DataOutput;
    import java.io.IOException;
    import java.nio.charset.Charset;

    import org.apache.hadoop.io.Writable;

    import com.google.common.base.Charsets;

    public class FileInfoWritable implements Writable {
        private final static Charset CHARSET = Charsets.UTF_8;
        private String createdDate;
        private String owner;
    //  private String lastModified;
        private String content;
        private String path;
        public FileInfoWritable() {

        }

        public void readFields(DataInput in) throws IOException {
            this.createdDate = readString(in);
            this.owner = readString(in);
    //      this.lastModified = readString(in);
            this.content = readString(in);
            this.path = readString(in);
        }

        public void write(DataOutput out) throws IOException {
            writeString(createdDate, out);
            writeString(owner, out);
    //      writeString(lastModified, out);
            writeString(content, out);
            writeString(path, out);
        }

        private String readString(DataInput in) throws IOException {
            final int n = in.readInt();
            final byte[] content = new byte[n];
            in.readFully(content);
            return new String(content, CHARSET);
        }

        private void writeString(String str, DataOutput out) throws IOException {
            out.writeInt(str.length());
            out.write(str.getBytes(CHARSET));
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getAuthor() {
            return owner;
        }

        public void setAuthor(String author) {
            this.owner = author;
        }

        /*public String getLastModified() {
            return lastModified;
        }*/

        /*public void setLastModified(String lastModified) {
            this.lastModified = lastModified;
        }*/

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }


    }