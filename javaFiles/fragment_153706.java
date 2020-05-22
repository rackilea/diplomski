public class WordPairFinder {
 public static void main(String args[]) {
  //I am making everything lower case so that the matching is case insensitive, you may want to be explicit about wordOne.toLower() and wordTwo.toLower()   
  //when you make a method of this routine, wordOne and wordTwo will become parameters 
  String wordOne = "est"; //feel free to change this to test
  String wordTwo = "laborum"; //ditto
  String notSplit = "    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
  String[] words = notSplit.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
  // above is from https://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
  boolean pairFound = false;
  for (int i = 0; i < words.length - 1; i++) { //note we have to stop at the penultimate word to avoid looking beyond the end of the array
   if (words[i].equals(wordOne) && words[i + 1].equals(wordTwo)) { //java wants normal quotes on its strings, check if current word followed by next word is the right pair
    pairFound = true;//you could break out of the loop here if you want
   }
  }
  System.out.println("With words " + wordOne + " and " + wordTwo + " value of pairFound is " + pairFound + ".");

 }
}