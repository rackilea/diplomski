int score;
static int scoremodifier;

public static void increaseAllScore() {
    scoremodifier++;
}

public int getScore() {
    return score + Game.scoremodifier;
}