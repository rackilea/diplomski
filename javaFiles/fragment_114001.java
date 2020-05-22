try{
    g2 = (Graphics2D) bs.getDrawGraphics();
    drawWhatEver(g2);
} finally {
       g2.dispose();
}
bs.show();