private class Player {
    public int id;
    public Info info;
}
private class Info {
    public int id;
    public Player parentPlayer;
}

// something like this:
Player player = new Player(1);
player.info = new Info(1, player);