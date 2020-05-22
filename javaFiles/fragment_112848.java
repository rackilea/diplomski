public class AssassinManager {

    LinkedList<AssassinNode> killring = new LinkedList<>();

    public AssassinManager(List<String> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException();
        }
        AssassinNode assassin = null;
        for (String player : players) {
            assassin = new AssassinNode(player, assassin);
            killring.add(assassin);
        }
    }

    public static void main(String[] args) {
        List<String> players = Arrays.asList("eizo", "shay", "arno", "arbaaz");
        AssassinManager manager = new AssassinManager(players);
    }
}