paint(Graphics g) {
    g.setColor(Color.BLACK);
    g.drawRect(0,0,640,480); // draw the black background

    // mask it with white
    g.setColor(Color.WHITE);
    for(int x = 0; x < 640); x++) {
        for(int y = 0; y < 480); y++) {
            if(mask[x][y]) g.drawRect(x,y,1,1);
        }
    }
}