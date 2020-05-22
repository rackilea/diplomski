Player player1 = new Player(Color.BLUE);
Player player2 = new Player(Color.RED);
Player player3 = new Player(Color.YELLOW);

final Iterator<Player> playerIterator = Iterators.cycle(player1, player2, player3);

canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
    if (e.getClickCount() == 1) {
        playerIterator.next().doSomething(root, e.getX(), e.getY());
    }
});