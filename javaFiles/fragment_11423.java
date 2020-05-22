import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.nio.file.Path;


public class SSSAlgorithm {

public static void main(String[] args) {
    System.out.println("Reading file");
    try {
        byte[] secret = readFile();
        createShares(secret, 2, 3, 100);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static byte[][] createShares(byte[] secret, int shares, int threshold, int i) 
{
    // some code here
    for (byte coeff : secret){
        System.out.println("Use the byte here " + coeff);
    }

    return null;
}


public static byte[] readFile() throws IOException {
    Path path = Paths.get("/Users/droy/var/crypto.txt");
    try {
        byte[] secret = Files.readAllBytes(path);
        return secret;

    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
}