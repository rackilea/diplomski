import java.util.Scanner;
import java.util.ArrayList;

class Main {

    public static void main(String arg[]){
    //Object to get user input
    Scanner in = new Scanner(System.in);

    //String array
    String[] strings = {"Kelder", "Slotgracht", "Raadsheer", "Dorp", "Militie", "Werkplaats", "Bureaucraat", "Feest", "Tuin", "Houthakker", "Geldschieter", "Verbouwing", "Smidse", "Spion", "Dief", "Troonzaal", "Raadszaal", "Festival", "Laboratorium", "Bibliotheek", "Markt", "Mijn", "Heks", "Avonturier"};

    // ArrayList to store string selected already
    ArrayList<String> selectedBefore = new ArrayList<String>();

    System.out.print("Hoeveel kaarten wil je?: ");
    //Get user input
    int numberOfTest = in.nextInt();

    for(int i = 0; i < numberOfTest; i++){
        int index = (int)(Math.random() * strings.length);

        // Keep checking if the string has been selected before
        while(selectedBefore.contains(strings[index]))
        {
          index = (int)(Math.random() * strings.length);
        }

        //store the string that was selected by Math.random() before:  
        selectedBefore.add(strings[index]);

        System.out.println(strings[index]);
    }
}

}