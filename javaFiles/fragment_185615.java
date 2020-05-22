public int getDifficulty() {
    int difficulty;
    switch (chosenDifficulty) {
        case "HUMAN":
            difficulty = 1;
            break;
        case "RANDOM":
            difficulty = 2;
            break;
        default:
            difficulty = 3;
    }
    return difficulty;
}