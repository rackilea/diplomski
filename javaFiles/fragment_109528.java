while (true) {
    x = fireballButton[c].getX();
    y = fireballButton[c].getY();
    fireballButton[c].setBounds(x + 5, y, 64, 32);
    c++;
    if (c == fireballTotal) {
        break;
    }
}