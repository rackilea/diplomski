static final Random random = new Random(System.currentTimeMillis());

public int random(int range, int multiple) {
    int value = random.nextInt(range / multiple) * multiple;
    return value == 0 ? 1 : value;
}