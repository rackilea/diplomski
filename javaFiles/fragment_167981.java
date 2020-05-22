void moveToProperPlace(GameRecord[] records, int index) {
    int newIndex = findCorrectIndex(records, index);
    if (newIndex != index) {
        GameRecord record = records[index];
        System.arrayCopy(records, newIndex, records, newIndex + 1, index - newIndex);
        records[newIndex] = record;
    }
}

int findCorrectIndex(records, index) {
    int i = index;
    do {
        i--;
    } while (i >= 0 && higher(records[index], records[i]);
    return i + 1;
}

boolean higher(GameRecord x, GameRecord y) {
    return x.getScore() > y.getScore() || (x.getScore() == y.getScore && x.getLevel() > y.getLevel());
}