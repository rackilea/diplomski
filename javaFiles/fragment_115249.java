import java.io.*;

class Test
{
    public static void main(String[] args) throws Exception
    {
        Process p = Runtime.getRuntime().exec("/path/to/iojs");
        OutputStream stdin = p.getOutputStream();
        InputStream stdout = p.getInputStream();
        File file = new File("/path/to/pageDown.js");
        byte[] b = new byte[(int)file.length()];
        FileInputStream in = new FileInputStream(file);
        for(int read = 0; read < b.length; read += in.read(b, read, b.length - read)); // <-- note the semicolon
        stdin.write(b);
        stdin.write("process.stdout.write(getSanitizedHtml('test `test` test'));".getBytes());
        stdin.close(); // <-- important to close
        p.waitFor();
        b = new byte[stdout.available()];
        stdout.read(b);
        System.out.println(new String(b));
    }
}