import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

List<String> lines = ...;
Files.write(log, lines, UTF_8, APPEND, CREATE);