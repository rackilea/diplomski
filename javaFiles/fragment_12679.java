public static void main(String[] args) {
    boolean finished = false;
    ArrayList<Character> firstLetters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    while (!finished) {
        firstLetters.add(scanner.next().charAt(0));
    }
}