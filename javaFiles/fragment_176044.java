public class qwixx {

    player[] Players;     //declared before using it in any methods / constructor

    public qwixx(String[] players) {
        Players = new player[players.length];    //value initialized inside the constructor
        for (int x = 0; x < players.length; x++) {
            Players[x] = new player(players[x]);
        }
    }

    public void play() {
        for (int i = 0; i < Players.length; i++) {
            System.out.println(Players[i].getName());
        }
    }
}