package arraywords;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Arraywords {
    public static void main(String[] args) {
        ArrayList<String>words = new ArrayList();
        words.add("Token");
        words.add("Magic");
        words.add("People");
        words.add("Racecar");
        words.add("Xbox");
        words.add("Puppy");
        words.add("Destiny");
        words.add("Knowledge");
        words.add("Home");
        words.add("Professional");

        int index = ThreadLocalRandom.current().nextInt(0, words.size());
        System.out.printf("Random Word Index:#%d:\n> %s.", (index+1), words.get(index));
    } 
}