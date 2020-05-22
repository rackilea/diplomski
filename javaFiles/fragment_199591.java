private static Integer[] getTwoMissingNumbers(List list) {

    int n = list.size() + 2;
    int expectedSum = n * (n + 1) / 2;
    int expectedSquaredSum = n * (n + 1) * (2 * n + 1) / 6;
    int sum = 0;
    int squaredSum = 0;

    System.out.println("SIZE :::" + list.size());

    for (Object num : list) {//use as object
        sum = sum + (int)num;//type cast the object in int format
        squaredSum = squaredSum + ((int)num * (int)num);//type cast the object in int format
    }

    int xplusy = expectedSum - sum;
    int xsquareplusysquare = expectedSquaredSum - squaredSum;
    int twoxy = xplusy * xplusy - xsquareplusysquare;
    int xminusy = (int) Math.sqrt(xsquareplusysquare - twoxy);
    int x = (xplusy + xminusy) / 2;
    int y = (xplusy - xminusy) / 2;

    return new Integer[] { x, y };
}