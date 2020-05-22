public class MyClassLoader extends ClassLoader
{
    final byte[] myByteArray = new byte[] {0x1, 0x2, 0x3};
    protected URL findResource(String name)
    {
        URL res = super.findResource(name);
        if (res != null) {
            res = new URL(null, "my-bytes:" + name, new URLStreamHandler() {
                protected URLConnection openConnection(URL u) {
                    return new URLConnection() {
                        public void connect() {}

                        public InputStream getInputStream() {
                            return new ByteArrayInputStream(myByteArray);
                        }
                    };
                }
            });
        }
        return res;
    }
}