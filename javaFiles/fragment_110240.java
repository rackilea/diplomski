import static java.nio.file.StandardCopyOption.*;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Files;
...
for (File file : files) {    
  if (file.getName().startsWith("A") ) {
     //here save file to d:\\folder1\\
     // convert file to Path object use toPath() method.
     Path targetFilePath = FileSystems.getDefault().getPath("d:\\folder1\\").resolve(file.getFileName())
     Files.move(file.toPath(), targetFilePath , REPLACE_EXISTING);
  }
}