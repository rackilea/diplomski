import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xhtmlrenderer.pdf.ITextOutputDevice;
import org.xhtmlrenderer.pdf.ITextUserAgent;

public class PackageUserAgentCallback extends ITextUserAgent {
    private Class resourceClass;

    public PackageUserAgentCallback(ITextOutputDevice outputDevice, Class resourceClass) {
        super(outputDevice);
        this.resourceClass = resourceClass;
    }

    @Override
    public byte[] getBinaryResource(String uri) {
        try {
            InputStream in = resourceClass.getResourceAsStream(uri);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int numRead;
            byte [] buffer = new byte[256];
            while((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
            }
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}