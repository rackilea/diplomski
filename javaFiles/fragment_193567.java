import java.io.File;
import org.springframework.core.io.*;

public String getFontFilePath(String classpathRelativePath) {
    Resource rsrc = new ClassPathResource(classpathRelativePath);
    return rsrc.getFile().getAbsolutePath();
}