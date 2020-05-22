public static ArrayList<GameTile> gameTiles = new ArrayList<GameTile>();

protected void paintComponent(Graphics g) {
    for(int i = 0; i < gameTiles.size(); i++) {
        gameTiles.get(i).draw(g);
    }