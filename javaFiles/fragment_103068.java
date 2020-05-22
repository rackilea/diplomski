int countF = 0;

public int getMove(CritterInfo info) {
    countF++;
    int moveF2 = 0;
    if (countF % 3 == 1) {
        int moveF = (int)(Math.random() * 100);
        moveF2 = moveF;
        countF = 0;
    } else {
    }
}