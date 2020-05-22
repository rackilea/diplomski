private int randomBetween(int min, int max) {
    int range = max - min;
    return min + numGen.nextInt(range);
}

...

g.setColor(new Color(randomBetween(80,256), randomBetween(80,256), randomBetween(80,256)));