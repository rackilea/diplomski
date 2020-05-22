@Override
public void paint(Graphics g) {
    super.paint(g);
    if (!al.isEmpty()) {
        int x = al.get(0).x;
        int y = al.get(0).y;
        for (int i = 1; i < al.size(); i++) {
            m = al.get(i).x;
            n = al.get(i).y;

            g.drawLine(m, n, x, y);

            x = m;
            y = n;

        }
    }
}