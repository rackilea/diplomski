public void print() {

    System.out.println("Enter a word: ");
    Scanner userInputF = new Scanner(System.in);
    String s = userInputF.nextLine();

    char[]  ray = s.toCharArray();

    for (int t = 0; t < s.length(); t++) {
        System.out.println(ray[t]);
    }
}