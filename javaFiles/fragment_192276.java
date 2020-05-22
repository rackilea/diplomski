import jdk.jfr.consumer.*;

try (RecordingFile r = new RecordingFile(Path.of("recording.jfr"))) {
 while (r.hasMoreEvents()) {
   System.out.println(r.readEvent());
 }
}