protected void paintComponent(Graphics g) {
    g.setColor(backgroundColor);
    g.fillRect(0, 0, getSize().width, getSize().height);
    super.paintComponent(g);
    setPreferredSize(new Dimension(47, 33));

    g.setColor(textColor); //set the text color before drawing the text
    if (isHeader) {
        g.setFont(new Font("Arial", Font.PLAIN, 11));
        g.drawChars(date.toCharArray(), 0, date.length(), 13, 20);
    } else {
        g.setFont(new Font("Arial", Font.PLAIN, 9));
        g.drawChars(date.toCharArray(), 0, date.length(), 3, 11);

        g.setFont(new Font("Arial", Font.PLAIN, 11));
        g.drawChars(hours.toCharArray(), 0, hours.length(), 18, 20);
    }
    super.paintComponent(g);
    setContentAreaFilled(false);
    g.finalize();
}