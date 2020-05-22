int w = i.getWidth();
int h = i.getHeight();

int[][] array = new int[w][h];
for (int j = 0; j < w; j++) {
    for (int k = 0; k < h; k++) {
        array[j][k] = i.getRGB(j, k); // or whatever
        System.out.println("jk=" + array[j][k]);
    }
}