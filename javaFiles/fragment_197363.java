import java.util.ArrayList;
import java.util.List;

public class KSmallestPairs {
    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }

    public static List<SumPair> kSmallestPairs(int[] leftInts, int[] rightInts, int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k (=" + k + ") must higher than 0!");
        } else if (leftInts.length * rightInts.length < k) {
            throw new IllegalArgumentException("k (=" + k
                    + ") cannot be higher than the length of the cartesian product (="
                    + leftInts.length * rightInts.length + ")");
        }

        final List<SumPair> sumPairs = new ArrayList<>();
        int minLeftIndex = 0;
        int minRightIndex = 0;
        for (int leftIndex = 0, rightIndex = 0;
             leftIndex < leftInts.length
                     && rightIndex < rightInts.length
                     && sumPairs.size() < k; ) {            
            final int leftInt = leftInts[leftIndex];
            final int rightInt = rightInts[rightIndex];
            sumPairs.add(new SumPair(leftInt, rightInt));

            if(leftIndex + 1 < leftInts.length && rightIndex + 1 < rightInts.length) {
                final int nextLeftInt = leftInts[leftIndex + 1];
                final int nextRightInt = rightInts[rightIndex + 1];
                final int sumOfLeftIntAndNextRightInt = leftInt + nextRightInt;
                final int sumOfNextLeftIntAndRightInt = nextLeftInt + rightInt;
                if(sumOfLeftIntAndNextRightInt < sumOfNextLeftIntAndRightInt) {
                    rightIndex++;
                } else {
                    leftIndex++;
                }
            } else if(leftIndex + 1 < leftInts.length) {
                leftIndex++;
                rightIndex = minRightIndex;
                minLeftIndex++;
            } else if(rightIndex + 1 < rightInts.length) {
                leftIndex = minLeftIndex;
                rightIndex++;
                minRightIndex++;
            }
        }
        return sumPairs;
    }

    static class SumPair {
        private final int leftInt;
        private final int rightInt;

        public SumPair(int leftInt, int rightInt) {
            this.leftInt = leftInt;
            this.rightInt = rightInt;
        }

        public int getLeftInt() {
            return leftInt;
        }

        public int getRightInt() {
            return rightInt;
        }

        public int getSum() {
            return leftInt + rightInt;
        }

        @Override
        public String toString() {
            return leftInt + "+" + rightInt + "="+ getSum();
        }
    }
}