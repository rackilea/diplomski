@Test
public void numOfColorsTest() {
    int[][] map = new int[][] {{4,2,2,1,4},{4,4,3,1,4},{1,1,4,2,1},{1,4,0,2,2},{4,1,4,1,1}};
    System.out.println(String.format("numOfColors: %s", numOfColors(map, new int[0], map.length-1)));

    map = new int[][] {{4,6,2,1,4},{4,4,3,1,4},{1,1,4,2,1},{1,4,0,2,2},{4,1,4,1,1}};
    System.out.println(String.format("numOfColors: %s", numOfColors(map, new int[0], map.length-1)));

    map = new int[][] {{4,4,4,4,4}};
    System.out.println(String.format("numOfColors: %s", numOfColors(map, new int[0], map.length-1)));
}

public static int numOfColors(int[][] map, int[] collector, int currentPosition) {
    int[] result = collector;
    if (currentPosition < 0) {
        return collector.length;
    }
    for (int color : map[currentPosition]) {
        boolean found = false;
        for (int aResult : result) {
            if (aResult == color) {
                found = true;
                break;
            }
        }
        if (!found) {
            int[] newResult = new int[result.length + 1];
            System.arraycopy(result, 0, newResult, 0, result.length);
            newResult[newResult.length - 1] = color;
            result = newResult;
        }
    }
    return numOfColors(map, result, currentPosition-1);
}