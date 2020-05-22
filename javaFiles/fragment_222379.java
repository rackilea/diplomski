import java.nio.file.Path;
import java.nio.file.Paths;
...

MultipartFile file =...;
Path tempFolder = ...;
Path tempFile = Paths.get(tempFolder.toString(), file.getName());

file.transferTo(tempFile);

//now the tempFile should have the data.
String[] commands = {"python.exe", "script.py", tempFile.toAbsolutePath().toString()};