class user {
    Scanner in = new Scanner(System.in);
    int guess1;

    void guess() {
        System.out.println("Guess the random number in 1-10");
        int guess1 = in.nextInt();
    }
}