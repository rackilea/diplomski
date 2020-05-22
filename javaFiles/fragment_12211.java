import java.nio.file.Files;
import java.nio.file.Paths;

//can throw an IOException
String filePath = "/path/to/layout.groovy";
String allText = new String(Files.readAllBytes(Paths.get(filePath)),StandardCharsets.UTF_8);