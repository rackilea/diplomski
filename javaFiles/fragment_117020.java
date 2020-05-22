public void changeCell(Cell c) {
    this.removeAll(); //erase everything from your JPanel
    this.revalidate; this.repaint();//I always do these steps after I modify my JPanel
    for (Cell cell : cells) {
        if (cell.getx() == c.getx() && cell.gety() == c.gety()) {
              this.add(c);
        else this.add(cell);
    }
}