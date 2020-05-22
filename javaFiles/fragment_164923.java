public static void main(String[] args)
{ 
    Scanner scnr = new Scanner(System.in);

    String word = "";
    String sentence = "";
    final String SENTINEL = "done";
    double count = 0;

    System.out.println("Enter multiple words: ");
    System.out.println("Enter done to finish: ");
    //remove the first prompt here..
    do {
        word = scnr.next();
        if(word.equalsIgnoreCase(SENTINEL))  //exit loop if "done" was input
            break;          
        count++;
        sentence += word + " ";
    } while (!(word.equalsIgnoreCase(SENTINEL)));

    System.out.println(sentence);           
}