/**
 * Class used to hold the result details.
 */
private static class Result {
    boolean isSum;

    int[][] pairs;

    int noOfPairs;

    Result(int value) {
        pairs = new int[value][2];
    }
}

public static Result isSum(int[] array, int val, int count) {
    Result result = new Result(count);
    int index = 0;
    for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
            //check if pair values add to given sum
            if (array[i] + array[j] == val) {
                int[] temp = new int[2];
                temp[0] = array[i];
                temp[1] = array[j];
                result.pairs[index++] = temp;
                result.noOfPairs++;
                count--;
                if (count == 0) {
                    //we got required no of pairs..now exit
                    result.isSum = true;
                    return result;
                }
            }
        }
    }
    return result;
}