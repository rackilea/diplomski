Random rand = new Random();

for (int count:=1; count<8; count++) {
    int randx = rand.nextInt(5);
    int randy = rand.nextInt(5);
    minePos[randx, randy] = true;
}