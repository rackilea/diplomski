import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFile {

    public static void main(String[] args) {
        List<Tile> list = new ArrayList<Tile>();
        String path = "C:/whatever/your/path/is/";
        File file = new File(path + "file.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text = null;
            while ((text = reader.readLine()) != null) {
                String[] pairs = text.split(" ");
                for(String pair : pairs) {
                    String[] chars = pair.split(":");
                    int id = Integer.parseInt(chars[0]);
                    int type = Integer.parseInt(chars[1]);
                    list.add(new Tile(id, type));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }
}

class Tile {
    int id;
    int type;

    Tile(int id, int type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tile [id=" + id + ", type=" + type + "]";
    }


}