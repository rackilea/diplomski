public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);      //Just a normal scanner

    System.out.println("Please enter in the pathname to the file you want to view.");
    String pathname = input.nextLine();          //Pathname to text file
    File book = new File(pathname);              //Creating a new file using the pathname

    if(book.canRead() == false)                  //If Java cant read the file, this will pop up
    {
        System.out.println("Your file cannot be read");
    }
    else if(book.canRead() == true)              //If Java can read the file, then this asks for the word to search for
    {
        System.out.println("Please enter in the word you wish to search for.");
        wordToSearchFor = input.nextLine();

        wordCounter(book);                        //Calls the method
  }

  System.out.println(wordToSearchFor.toLowerCase() + " appeared " + numOfOccurrences + " times in " + pathname);

}