public static void main(String[] args) throws IOException {
{
    int word =0;
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter file name");
    String fileName=scan.next().trim();
    System.out.println("Enter the word you want to scan: ");
    //You have to insert this line in order to ask the user to input the word to find
    String wordTofind=scan.next().trim();
    Scanner scr = new Scanner(new File(fileName));
    // You should fix also here: scan the file and look if the word is present
    while(scr.hasNext()){
        String word1 = scr.next();
        if (word1.equals(wordTofind)){
            word++;
        }
    }
    System.out.println("Total words = " + word);
    }
}