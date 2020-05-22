import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        Gson gson = new GsonBuilder().create();
        BlockIndexFile blockIndexFile;
        try (FileReader fileReader = new FileReader(jsonFile)) {
            blockIndexFile = gson.fromJson(fileReader, BlockIndexFile.class);
        }
        Block node0 = blockIndexFile.getBlocks().get(0);
        System.out.println(node0);
    }
}

class BlockIndexFile {

    private List<Block> blocks = new ArrayList<>();

    // getters, setters
}

class Block {

    private String id;
    private String name;
    private String model;
    private String texture;

    // getters, setters, toString
}