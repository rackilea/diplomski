public class HttpFile {
    public final String status;
    public final Map<String, String> properties;
    public final byte[] data;

    public HttpFile(String status, Map<String, String> properties, byte[] data) {
        this.status = status;
        this.properties = properties;
        this.data = data;
    }

    public static HttpFile readFrom(DataInputStream dis, Charset charset) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch;
        while((ch = dis.read()) != -1) {
            baos.write(ch);
            if (ch == '\n') {
                ch = dis.read();
                // the second newline??
                if (ch == '\n')
                    break;
                baos.write(ch);
            }
        }
        String header = new String(baos.toByteArray(), charset);
        String[] lines = header.split("\\n");
        String status = lines[0];
        Map<String, String> properties = new LinkedHashMap<String, String>();
        for(int i=1;i<lines.length;i++) {
            String[] keyValue = lines[i].split(": ",2);
            properties.put(keyValue[0], keyValue[1]);
        }
        byte[] data = null;
        String content_length = properties.get("context-length");
        if (content_length != null) {
            int length = Integer.parseInt(content_length);
            dis.readFully(data = new byte[length]);
        }
        return new HttpFile(status, properties, data);
    }
}