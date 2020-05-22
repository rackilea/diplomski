import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.*;

public class MadLib {
    private ArrayList<String> verbs = new ArrayList<String>();
    private ArrayList<String> nouns = new ArrayList<String>();
    private ArrayList<String> adjectives = new ArrayList<String>();

    public static void main(String args[]) {
        MadLib a = new MadLib();
        System.out.println(a.toString());
    }

    public MadLib() {
        loadAllWords();
        System.out.println(nouns);
    }

    public MadLib(String fileName) {
        loadAllWords();

        try {
            Scanner file = new Scanner(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadAllWords() {
        loadNouns();
        loadVerbs();
        loadAdjectives();
    }

    public void loadNouns() {
        nouns = loadFile("nouns.dat");
    }

    public void loadVerbs() {
        verbs = loadFile("verbs.dat");
    }

    public void loadAdjectives() {
        adjectives = loadFile("adjectives.dat");
    }

    public ArrayList<String> loadFile(String filename) {
        ArrayList<String> words = new ArrayList<String>();
        try {
            Scanner chopper = new Scanner(new File(filename));
            while (chopper.hasNext()) {
                words.add(chopper.next());
                // just calling nextLine will cause an exception at the end of the file unless you have an blank line there on purpose, so this makes sure it does
                if (chopper.hasNext()) {
                    chopper.nextLine();
                }
            }
            chopper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    public String getRandomWord(ArrayList<String> words) {
        Random rand = new Random();
        int num = rand.nextInt(words.size());
        String word = nouns.get(num);
        System.out.println(word);
        return word;
    }

    public String getRandomVerb() {
        if (verbs == null) {
            loadNouns();
        }
        return getRandomWord(verbs);
    }

    public String getRandomNoun() {
        if (nouns == null) {
            loadNouns();
        }
        return getRandomWord(nouns);
    }

    public String getRandomAdjective() {
        if (adjectives == null) {
            loadNouns();
        }
        return getRandomWord(adjectives);
    }

    public String toString() {
        return "The " + getRandomNoun() + " " + getRandomVerb() + " after the " + getRandomAdjective()  + " " +  getRandomAdjective()  + " " +  getRandomNoun() + " while the " + getRandomNoun()  + " " +  getRandomVerb() + " the " + getRandomNoun();
    }
}