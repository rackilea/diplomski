import java.io.File;
import java.io.IOException;

public class Login {

static String   playerName;

public static void main(String[] args) {
    playerName = "John"; //set playerName to the name of the player
    createFile();
}

public static void createFile() {

    File f = new File("res/" + playerName + ".txt");
    if (!f.exists())
        try {
            f.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

}

public static String getSavePath(){
        return "res/" + playerName + ".txt";


}

}