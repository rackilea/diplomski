public static void main(String[] args) {
    displayHighScore(2, 1);  // for example this is a wrong paramerer error
    displayHighScore("C. Bryan", 1);  // this is ok!

}

public static void displayHighScore(String playersName, int position) {
    System.out.println(playersName + " managed to get to position " + position);

}