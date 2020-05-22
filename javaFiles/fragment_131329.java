switch (c) {
    case 'Q':
        g2.setColor(Color.BLACK);
        g2.fillRect(x, y, width, height);
        break;
    case 'H':
        g2.setColor(Color.GREEN);
        g2.fillRect(x, y, width, height);
        break;
    case 'f':
        //g2.setColor(Color.ORANGE);
        g2.drawImage(img, x, y, width, height, null);
        break;
    case '-':
        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, width, height);
        break;
    case '\n':
        y += height;
        x = 0; 
}