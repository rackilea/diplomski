import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        Gson gson = new GsonBuilder().create();
        BlockIndexFile blockIndexFile;
        try (FileReader fileReader = new FileReader(jsonFile)) {
            blockIndexFile = gson.fromJson(fileReader, BlockIndexFile.class);
        }
        HashMap<String, String> node0 = blockIndexFile.getBlocks().get(0);
        System.out.println("id => " + node0.get("id"));
        System.out.println("model => " + node0.get("id"));
        System.out.println("texture => " + node0.get("id"));
    }
}