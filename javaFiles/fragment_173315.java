public class Game {

        void createPlayers(Player[] players) {
            Player player1 = new Player();
            player1.setName("human");

            Player player2 = new Player();
            player2.setName("Greg");

            Player player3 = new Player();
            player3.setName("Susan");

            players[0] = player1;
            players[1] = player2;
            players[2] = player3;
        }

        public static void main(String[] args) {
            Player[] players = new Player[3];

            Game obj = new Game();
            obj.createPlayers(players);

            for (Player pl : players) {
                System.out.println("Name = " + pl.getName());
            }
        }
    }