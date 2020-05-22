DrawingPanel panel = new DrawingPanel(400, 480); // 12 rows, not 13
...
for (int x = 0; x < 10; x++) {
    for (int y = 0; y < 12; y++) {  // < instead of <=
        ...
        g.drawString((x+1)  + " * " + (y+1), cornerX + 5, cornerY + 15); // text is
        g.drawString("" + (x+1) * (y+1), cornerX + 5, cornerY + 33); // offsets
    }
}