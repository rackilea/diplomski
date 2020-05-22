public static void placeFish(int[][] pond, int newFish) {
    int spot = 0;
    int a;
    int b;

    do
    {
        a = random.nextInt(pond.length);
        b = random.nextInt(pond[0].length);
    } while (pond [a][b] != spot);

    pond[a][b] = newFish;
}