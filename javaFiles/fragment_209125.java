int row = -1;
int col = -1;

for (int i = 0; i < 9; i++) {
    int yPos = (i + 1) * 50 - 15;
    if (y >= yPos && y <= yPos + 50) {
        row = i;
        break;
    }
}
for (int j = 0; j < 9; j++) {
    int xPos = j * 50 + 15;
    if (x >= xPos && x <= xPos + 50) {
        col = j;
        break;
    }
}