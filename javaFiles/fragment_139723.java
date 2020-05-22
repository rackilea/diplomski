if (code == KeyEvent.VK_SPACE) {
    readyTofire = true;
    if (readyTofire) {
        int bx = x + 26;
        int by = y - 15;
        bullet = new Rectangle(bx, by, 5, 3);
        shot = true;
    }
}