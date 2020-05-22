public class julia1 {

public static void main(String[] args) {

    System.out.print("enter text to guess: ");
    String phraseToSearch = Keyboard.readString();
    char guessedConsonant; String temp= "";
    String displayWithAsterix = "";
    boolean character  = false, vowel = false, consonant =false, number= false;

    for(int charIndex = 0; charIndex < phraseToSearch.length(); c++){
        if(phraseToSearch.charAt(charIndex)==(' ')) displayWithAsterix = displayWithAsterix + " ";
        else displayWithAsterix = displayWithAsterix + "*";
    }

    System.out.println(displayWithAsterix);
    for (int trys = 0; trys <=5; trys++){ 
        temp=""; 
        //Warning!  When trys = 2, you haven't reset the boolean flags 
        //from the previous iteration!
        //If you entered '2', after a letter last time, then after the checks below, you would have:
        //character = true
        //vowel = false
        //consonant = true
        //number = true
        System.out.print("enter a consonant: ");
        guessedConsonant = Keyboard.readChar();

        //It looks like you want to validate that the guess is a consonant.
        //You don't need a loop to view a single char,
        //and w, or what I have renamed: phraseToSearch
        //is not the guessd char.
        for (int i = 0; i < phraseToSearch.length(); i++)
        {

            if (phraseToSearch.charAt(i) >= 'a' && phraseToSearch.charAt(i)<='z')
                character = true;

            if (phraseToSearch.charAt(i) >= 'A' && phraseToSearch.charAt(i)<='Z')
                character = true;

            if (character == true){
                switch (phraseToSearch.charAt(i)){
                    case 'a': case 'A': case 'o': case 'O':
                    case 'e': case 'E':
                    case 'i': case 'I':
                    case 'u': case 'U': vowel = true; break;
                    default : consonant = true;
                }        
                if (guessedConsonant >= '0' && guessedConsonant <='9')
                number=true;        


            }
        }

        for(int charIndex = 0; charIndex < phraseToSearch.length(); c++){ 
            if((phraseToSearch.charAt(charIndex)==guessedConsonant) && (consonant == true ))
                //Great, we're adding a hit guess to the output
                temp = temp + guessedConsonant;
            else if (vowel==true) {
                //And an whatever is in the developing display string if it's a vowel, good.
                temp = temp + displayWithAsterix.charAt(charIndex);
                //This, and the next print, look like they should be above, validing that the input
                //is a valid consonant.
                System.out.println("this is a vowel not consonant");
            }
            else {
                System.out.println("this is not a valid letter");
                //But what about the output string, don't we still need to add to it  here?                    
            }     
                //And what if it's a consonant, but doesn't match?
                //Shouldn't you still add:
                //temp = temp + displayWithAsterix.charAt(charIndex);
        }
        displayWithAsterix = temp; 
        System.out.println(displayWithAsterix) ;
    } 
}
}