@Override
public void mouseClicked(MouseEvent arg0) {
    neerslag.move(i);
    i++;
    neerslag.revalidate();
    neerslag.repaint();
    this.add(neerslag.showPaint());
}