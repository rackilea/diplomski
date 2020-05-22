public class GameTime {
    public static void main(String[]args) {
        // First players "Fred" and "Bill"
        Players hockeyPlayer = new Players("fred", "bill");
        hockeyPlayer.simpleMessage();
        hockeyPlayer.playersFight();

        // New players "Amy" and "Sam"
        hockeyPlayers.changePlayers("amy", "sam");
        hockeyPlayer.simpleMessage();
        hockeyPlayer.playersFight();
    }
}

public class Players {
    private String name;
    private int number;

    public Players(String player1, String player2) {
        name = player1 + " fights " player2;
    }

    public void changePlayers(String player1, String player2) {
        name = player1 + " fights " player2;
    }

    public void simpleMessage(){
        System.out.println("This is another Class");
    }

    public void playersFight() {
        System.out.println(name); 
    }
}