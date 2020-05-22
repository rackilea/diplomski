public boolean drawNumber(int i) {

    Random rnd = new Random();
    int number = rnd.nextInt(i);

    if (number == 0) {
        return true;
    }

    return false;
}