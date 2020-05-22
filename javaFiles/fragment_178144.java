class PlayerSender {

    private ObjectOutputStream outputStream;

    public PlayerSender(OutputStream out) {
        this.outputStream = new ObjectOutputStream(out);
    }

    public void send(Player player) {
        this.outputStream.writeObject(player);
    }

}

//---- Usage ----

List<Player> players = // make a bunch of players;

PlayerSender playerSender = new PlayerSender(getNetworkStream());
//PlayerSender playerSender = new PlayerSender(new FileOutputStream("/players/list.txt");
//PlayerSender playerSender = new PlayerSender(socketConnection.getOutputStream());
for (Player player : players) {
    playerSender.send(player);
}