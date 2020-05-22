import java.util.*;
import java.lang.*;
import java.io.*;

class HaveFile {
    public static void main(String[] args) {
        try {
            boolean trouve = false;
            System.out.println("Entrer le film a chercher");
            Scanner input = new Scanner(System.in);
            String word = input.nextLine();
            Scanner films = new Scanner(new File(args[0]));

            while (films.hasNextLine() == true) {
                String line = films.nextLine();
                if (line.contains(word)) {
                    trouve = true;
                    System.out.println("ok");
                }
            }
            if (trouve) {
                System.out.println("Le film est présent");
            } else {
                System.out.println("Le film n'est pas présent");
            }
            System.out.println("Continuer ( entrer ) ou quitter");
            word = input.next();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}