public class SumsInLoop {
    //pairsOfInts should be an [n][2] array
    private static int[] sumOfPairs(int[][] pairsOfInts) {

        int[] sums = new int[pairsOfInts.length];
        for(int pairIndex = 0; pairIndex < pairsOfInts.length; pairIndex++) {
            sums[pairIndex]= pairsOfInts[pairIndex][0]+pairsOfInts[pairIndex][1];
        }
        return sums;
    }

    public static void main(String[] args) {
        int numberOfPairs = 2;
        int[][] pairsOfInts = new int[numberOfPairs][2];
        pairsOfInts[0] = new int[] {612673,108695 };
        pairsOfInts[1] = new int[] {756875,496058 };
        int[] sumOfPairs = sumOfPairs(pairsOfInts);
        System.out.println(Arrays.toString(sumOfPairs));
    }
}