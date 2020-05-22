import java.util.Scanner;

class Game {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String word = null;
    char[] letters;
    char[] underScores;
    char guess;
    int found=0;
    int mistake=0;
    boolean present = false;

    System.out.println("Enter the word");
    word = s.nextLine();

    letters = word.toCharArray();
    underScores = new char[letters.length];
    for(int i = 0; i<letters.length;i++) {
      underScores[i]='_';
    }

    while(true) {
      System.out.println("The word is");
      for(int i = 0; i<letters.length;i++) {
        System.out.print(underScores[i]);
      }

      System.out.println("\nEnter a letter");
      guess= s.nextLine().charAt(0);

      for(int i =0; i<letters.length;i++) {
        if(guess==letters[i]) {
          underScores[i]=guess;
          found+=1;
          present=true;
          break;
        }
      }

      if(!present) {
        System.out.println("the letter is not present");
        mistake+=1;
      }

      if(mistake >=7) {
        System.out.println("too many mistakes!! sorry");
        break;
      }

      if(found==letters.length){
        System.out.println(word);
        System.out.println("you have found the word!!");
        break;
      }
    } //ending while
  } //ending main
} //ending Game