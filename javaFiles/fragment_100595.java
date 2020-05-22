public void drawString(Graphics g, String s, int x, int y, int width)
{
    // FontMetrics gives us information about the width,
    // height, etc. of the current Graphics object's Font.
    FontMetrics fm = g.getFontMetrics();

    int lineHeight = fm.getHeight();

    int curX = x;
    int curY = y;

    String[] words = s.split(" ");

    for (String word : words)
    {
        // Find out thw width of the word.
        int wordWidth = fm.stringWidth(word + " ");

        // If text exceeds the width, then move to next line.
        if (curX + wordWidth >= x + width)
        {
            curY += lineHeight;
            curX = x;
        }

        g.drawString(word, curX, curY);

        // Move over to the right for next word.
        curX += wordWidth;
    }
}