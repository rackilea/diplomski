import java.util.*;
public class MMStarWarsNG {

    /**
     * @param c
     * @return
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in); //creates the scanner that allows user input

        System.out.print("What is your first name? ");
        String firstName = sc.nextLine(); //creates new line after user hits enter
        firstName = firstName.substring(0, 3); //locates the first three characters the the user typed. In this case the character are 0,1,2.

        System.out.print("What is your last name? ");
        String lastName = sc.nextLine();
        lastName = lastName.substring(0, 4); //takes the first 4 characters the the user typed, characters: 0,1,2,3

        System.out.print("What is your favorite city? ");
        String favCity = sc.nextLine();
        favCity = favCity.substring(favCity.length() - 3); //takes the final 3 characters that the user typed
        favCity = favCity.substring(0, 1).toUpperCase() + favCity.substring(1); //takes the first character typed and capatilizes it

        System.out.print("What is the first name of a good friend? ");
        String friend = sc.nextLine();
        friend = friend.substring(friend.length() - 3);
        friend = friend.substring(0, 1).toUpperCase() + friend.substring(1);

        String SWName = favCity + firstName + " " + friend + lastName;//adds all of the substrings together. The space after firstName is the space between the first and last name

        StringBuilder SWNameWapos = apostropheAdder(SWName);

        System.out.println(SWNameWapos); //prints the line above
    }

    public static boolean consonantFinder(char c) {

        String vowels = "euioa ";

        for (int i = 0; i < vowels.length(); i++) {

            if (c == vowels.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder apostropheAdder(String a) {
        StringBuilder s = new StringBuilder(a);
        //adds apostrophe
        int position;
        for (position = 1; position < s.length(); position++) { //linear search for the length of the string
            if (consonantFinder(s.charAt(position))) { //finds position
                s.insert(position, "'");
                position++;
            }
        }
        return s;
    }
}