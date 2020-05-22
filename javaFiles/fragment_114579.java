import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import com.google.gson.GsonBuilder;

public class GsonMain{
public static void main(String[] args) throws IOException {
    String filename = "d:/test.json"; // contains the json
    String content = new String(Files.readAllBytes(new File(filename).toPath()));

    GsonBuilder b = new GsonBuilder();
    b.registerTypeAdapter(Decode.class, new MyDeserializer());
    Decode[] array = b.create().fromJson(content, Decode[].class);
    System.out.println(Arrays.toString(array));
  }

 }