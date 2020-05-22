public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Spaceship s : playingList)
        s.drawSpaceship(g);
    t.start();
}