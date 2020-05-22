public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("Test.txt"));
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the subtring to look for: ");
    String word = sc.next();
    String line = in.readLine();
    int count = 0;
    // here is where the efficiently magic happens
    do {
    // 1. you dont need to split a line by spaces, too much overhead...
    // 2. and you dont need to do counter++
    // 3. do instead: calculate the number of coincidences that the word is
    //repeated in a whole line...that is what the line below does..
        count += (line.length() - line.replace(word, "").length()) / word.length();
    //the rest looks fine

    //NOTE: if you need a whole word then wrap the input of the user and add the empty spaces at begin and at the end...so the match will be perfect to a word

        line = in.readLine();
    } while (line != null);
    System.out.print("There are " + count + " occurences of " + word + " in ");
    }