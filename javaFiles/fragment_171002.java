import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadBlocks {
    private static final String RESOURCE_PATH = "blocks.txt";
    private static final String NEW_BLOCK = "$";

    public static void main(String[] args) {
        List<Block> blocks = new ArrayList<>();

        InputStream resource = ReadBlocks.class.getResourceAsStream(RESOURCE_PATH);
        Scanner blockScanner = new Scanner(resource);

        Block currentBlock = null;
        while (blockScanner.hasNextLine()) {
            String line = blockScanner.nextLine();
            String[] tokens = line.split("\\s+");
            if (tokens[0].equals(NEW_BLOCK)) {
                currentBlock = createBlockFromTokens(tokens);
                blocks.add(currentBlock);
            } else if (currentBlock != null) {
                currentBlock.addLine(createLineFromTokens(tokens));
            }
        }

        if (blockScanner != null) {
            blockScanner.close();
        }

        for (Block block : blocks) {
            System.out.println(block);
        }
    }

    private static Line createLineFromTokens(String[] tokens) {
        if (tokens.length < 4) {
            // throw exception
        }
        int x = Integer.parseInt(tokens[1]);
        int y = Integer.parseInt(tokens[2]);

        Line line = new Line(x, y);
        String[] names = tokens[3].split(",");
        for (String name : names) {
            line.addName(name);
        }
        return line;
    }

    private static Block createBlockFromTokens(String[] tokens) {
        if (tokens.length < 4) {
            // throw exception
        }
        int x = Integer.parseInt(tokens[1]);
        int y = Integer.parseInt(tokens[2]);
        String name = tokens[3];
        return new Block(name, x, y);
    }
}