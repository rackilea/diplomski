// NOTE: java naming convntion: capital class names
// complete documentation see here: http://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html
public class Hangdamang {

    public static void main(String[] args) throws FileNotFoundException {

        // Engine
        // NOTE: it is c-style to declare all needed variables in top of the method
        // in java you can declare them close to where you need them. Provides better readability at no costs.
        Scanner input = new Scanner(System.in);
        Scanner ord = new Scanner(new File("words.txt")); // for example zyzzyva.net/wordlists.shtml        
        int gissningar = 0;
        // Arraylist, här sparas alla ord
        ArrayList<String> arswag = new ArrayList<String>();
        // while loop, tar ord från words.txt och lägger till arraylisten.
        while(ord.hasNext()) {
            arswag.add(ord.nextLine());
        }
        //Väljer ett random ord i arraylisten.
        Collections.shuffle(arswag);
        String pickWord = arswag.get(0).split(" ")[0].toLowerCase();
        System.out.println(pickWord);

        // hold a list of not yet guessed letters 
        List<Character> unknownLetters = new LinkedList<Character>(); // NOTE: you could as well use ArrayList
        for(Character c = 'a'; c<='z'; c++)
            unknownLetters.add(c);

        //Riktiga spelet:
        System.out.println("Välkommen till mitt hänga gubbe spel.");
        System.out.println("Längden på ordet du ska gissa är: " + pickWord.length());
        String guess="";
        String showWord="";
        while(!guess.equalsIgnoreCase(pickWord) && !showWord.equalsIgnoreCase(pickWord)) {

            System.out.println(showWord);

            System.out.println("\n" + "Skriv en bokstav för att gissa ordet.");
            System.out.println("Antal gissningar du gjort: " + gissningar);
            gissningar++;
            guess = input.next();

            if(guess.length()==1) {
                unknownLetters.remove(Character.valueOf(guess.charAt(0)));
                showWord = pickWord;
                for(Character c : unknownLetters)
                    showWord=showWord.replaceAll(c.toString(), "_");
            }

        }

        System.out.println("You won! Tries needed: "+gissningar);

    }
}