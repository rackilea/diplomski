public class App {
    public static void main(String[] args) {
        PlayerInput input = new PlayerInput(new Scanner(System.in));
        int count = input.getCount();
        List<Player> players = input.inputPlayers(count);
    }
}