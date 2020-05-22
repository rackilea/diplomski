public void mousePressed() {
    for (int i = 0; i < 6; i++) {
        if(mouseX() >= cards[i].x && mouseX() <= cards[i].x+cards[i].width && mouseY() >= cards[i].y && mouseY() <= cards[i].y+card[i].height) {
            cards[i].flip();
        }
    }
}