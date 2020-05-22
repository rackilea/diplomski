public class Team {
        private List<Player> players;

        Team(List<Player> players) { 
           this.players = players;
        }

        public void add(Player player) {
            players.add(player);
        }

        public void remove(Player player) {
            players.remove(player);
        }

        public double averageAge() {
            double sum = 0;
            double amount = players.size();
            for (Player player : players) {
                sum += player.age();
            }
            return sum / amount;
        }

    }