package fractalTerrain.midpointDisplacement;
import java.io.*;
import java.util.Random;

public class MonochromeMidpointDisplacement {
    private static final String onName = "src\\fractalTerrain\\midpointDisplacement\\test2.bmp";
    private Random random = new Random();
    private static final int H_GRID = 257;
    private static final int V_GRID = H_GRID;
    public static void main(String[] args) {
        MonochromeMidpointDisplacement midpointDisplacement = new MonochromeMidpointDisplacement();
        midpointDisplacement.go();   
    }
    private void go(){
      //  fillMap(map, min, max);
        printMap();
    }

    public void printMap(){
        // 3.0 output to file
        // 3.1 Begin the file
        // 3.1.1 open output file
        FileOutputStream writer = null;
        try {
            writer = new FileOutputStream(new File(onName));

            // 3.1.2 copy the header
            // 3.1.2.1 magic number
            writer.write(66);
            writer.write(77);

            // 3.1.2.2 file size/unused space
            for (int i = 0; i < 8; i++){
                writer.write(0);
            }
            // 3.1.2.3 data offset
            writer.write(54);

            // 3.1.2.4 unused space
            for (int i = 0; i < 3; i++){
                writer.write(0);
            }

            // 3.1.2.5 header size
            writer.write(40);
            // 3.1.2.6 unused space
            for (int i = 0; i < 3; i++){
                writer.write(0);
            }

            // 3.1.2.7 file width (trickier)
            writer.write(H_GRID % 256);
            writer.write(H_GRID >> 8 % 256);
            writer.write(H_GRID >> 16 % 256);
            writer.write(H_GRID >> 24 % 256);

            // 3.1.2.8 file height (trickier)
            writer.write(V_GRID % 256);
            writer.write(V_GRID >> 8 % 256);
            writer.write(V_GRID >> 16 % 256);
            writer.write(V_GRID >> 24 % 256);

            // 3.1.2.9 color planes
            writer.write(1);
            writer.write(0);

            // 3.1.2.10 bit depth
            writer.write(24);

            // 3.1.2.11 the rest
            for (int i = 0; i < 25; i++){
                writer.write(0);
            }

            for(int i = 0; i < V_GRID; i++){
                for(int g = 0; g < H_GRID; g++){
                    writer.write(255);
                    writer.write(0);
                    writer.write(0);
                }
                for (int k = 0; k < (H_GRID % 4); k++){
                    writer.write(0);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}