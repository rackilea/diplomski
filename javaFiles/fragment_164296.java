private void putChar(int dx, int dy, char ch, int fore, int back) {
    int charIdx = 0;
    int canvasIdx = dy * canvas.w + dx;
    for (int i = 0; i < CHAR_HEIGHT; i++) {
        for (int j = 0; j < CHAR_WIDTH; j++) {
            canvas.data[canvasIdx] = font[ch][charIdx] ? fore : back;
            charIdx++;
            canvasIdx++;
        }
        canvasIdx += canvas.w - CHAR_WIDTH;
    }
}