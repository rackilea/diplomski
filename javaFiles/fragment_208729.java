public void test() throws IOException
{
    InputStream in = null;
    try {
        if(file.exists()) {
            in = new FileInputStream( file );
        } else {
            in = new URL( "some url" ).openStream();
        }
        // Do something useful with the stream.
    } finally {
        close(in);
    }
}

public static void close(InputStream is) {
    try {
        if (is != null) {
            is.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}