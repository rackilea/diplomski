//In your GuessGame class
int number = 0;
public void foo() {
    number++;
}

public static void main(String[] args) {
    GuessGames games = new GuessGames();
    games.foo();
    System.out.println(games.number);
    //Outputs 1
}