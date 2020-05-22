import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MyWordCount {
public static void main(String[] args) {

    // Text in
    String inText = JOptionPane.showInputDialog("Write some text here");

    // Puts it into an array, and splits
    String[] wordlist = inText.split(" ");

    // Text out (Header)
    System.out.println("Place:\tWord:\tNo. of Words: ");

    // declare Arraylist for words
    ArrayList<String> wordEncounter = new ArrayList<String>();
    ArrayList<Integer> numberEncounter = new ArrayList<Integer>();

    // Checks number of encounters of words
    for (int i = 0; i < wordlist.length; i++) {
        String word = wordlist[i];

        // Make everything lowercase just for ease...
        word = word.toLowerCase();

        if (wordEncounter.contains(word)) {
            // Checks word encounter - return index of word
            int position = wordEncounter.indexOf(word);
            Integer number = numberEncounter.get(position);
            int number_int = number.intValue();
            number_int++;
            number = new Integer(number_int);
            numberEncounter.set(position, number);

            // Number of encounters - add 1;
        } else {
            wordEncounter.add(word);
            numberEncounter.add(new Integer(1));
        }

    }

    // Text out (the list of words)
    for (int i = 0; i < wordEncounter.size(); i++) {
        System.out.println(i + "\t" + wordEncounter.get(i) + "\t"
                + numberEncounter.get(i));
    }

  }
}