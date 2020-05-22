int x1 = 0;
int y1 = 0;
int x2 = 100;
int y2 = 0;

for (int i = 0; i < x2; i++){
    g.drawLine(x1, y1, x2, y2);
    x1 += 1;
    y1 += 1;
    y2 += 1;
}