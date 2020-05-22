// For easy mode and also utilized in smartMove() for medium mode
public int randomMove(int player) {

    int rnum = 0;

    rnum = rand.nextInt(8);
    while (emptyCheck(rnum) != true) {  // <--------- HERE

        rnum = rand.nextInt(8);

    }