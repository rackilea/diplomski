public void drawChangableText(int x, int y, String text) {
    //pick your color
    Color.black.bind();
    //do the job
    gameFont.drawString(x, y, text, Color.black);
    //reset the color
    Color.white.bind();
}