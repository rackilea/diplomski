private void tick() {
    for (THead head : heads) {
        head.tick();
    }
    for (TTail tTail : tails) {
        tTail.tick();
    }
    synchronized(tails) {
        tail.removeIf(o -> !o.isAlive());
    }
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    synchronized(tails) {
        for (TTail tTail : tails) {
            tTail.paint(g2d);
        }
    }
    for (THead head : heads) {
        head.paint(g2d);
    }
}