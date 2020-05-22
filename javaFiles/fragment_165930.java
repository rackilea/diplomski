String currentLine;
List<Player> playerList = new ArrayList<>();
while ((currentLine = br.readLine()) != null) {
    Player p = new Gson().fromJson(currentLine, Player.class);
    System.out.println(p.toString());
    playerList.add(p);
}