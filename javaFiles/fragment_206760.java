public class ContextAwareDuplicatorOutputStream extends OutputStream {

FileOutputStream insideContext;
FileOutputStream outsideContext;

public ContextAwareDuplicatorOutputStream(String insideContextPath,
        String outsideContextPath, String fileName)
        throws FileNotFoundException {
    insideContext = new FileOutputStream(insideContextPath
            + File.pathSeparator + fileName);
    outsideContext = new FileOutputStream(outsideContextPath
            + File.pathSeparator + fileName);
}

@Override
public void close() throws IOException {
    insideContext.close();
    outsideContext.close();
}

@Override
public void flush() throws IOException {
    insideContext.flush();
    outsideContext.flush();
}

@Override
public void write(byte[] b) throws IOException {
    insideContext.write(b);
    outsideContext.write(b);
}

@Override
public void write(byte[] b, int off, int len) throws IOException {
    insideContext.write(b, off, len);
    outsideContext.write(b, off, len);
}

@Override
public void write(int b) throws IOException {
    insideContext.write(b);
    outsideContext.write(b);
}