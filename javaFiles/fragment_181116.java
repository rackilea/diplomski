long prevTimeMillis = System.currentTimeMillis();
int i = 0;
while (i < 20) {
    final long elapsedMillis = System.currentTimeMillis() - prevTimeMillis;
    final double randomNum = 2000 * Math.random() - 1000;
    if (elapsedMillis > 5000 + randomNum) {
        System.out.println("Random Num: " + randomNum);
        prevTimeMillis = System.currentTimeMillis();
        i++;
    }
}