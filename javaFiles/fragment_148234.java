public class Sample5 {
        private static long maxSumRec(int[] a, int low, int high) {
            long  leftSum = 0, rightSum = 0;
            long  sum = 0; 

            if (low == high) { // Base case
                return a[low]; 
            }

            int mid = (low + high)/2; // (low + high) / 2
            long maxLeftSum = maxSumRec(a, low, mid);
            long maxRightSum = maxSumRec(a, mid + 1, high);

            //max-crossing-subarray
            for (int i = mid; i >= low; i--) {
                sum += a[i];
                if (sum > leftSum) {
                    leftSum = sum;
                }
            }
            sum = 0;
            for (int i = mid + 1; i <= high; i++) {
                sum += a[i];
                if (sum > rightSum) {
                    rightSum = sum;
                }
            }
            System.out.println("final left sum "+leftSum);
            System.out.println("final right sum "+rightSum);
            System.out.println("leftSum+rightSUM:"+(leftSum + rightSum));
            return max3(maxLeftSum, maxRightSum, (leftSum + rightSum));
        }

        private static long max3(long a, long b, long c) {
            return a > b ? (a > c ? a : c) : (b > c ? b : c);
        }

        private static int sum(int[] a,int i,int j){
            int r=0;
            for(int k=i;k<=j;k++){
                r+=a[k];
            }
            return r;
        }
        public static void main(String[] args) {


            //INPUT
            int a[] = {
                -5, 71, 23, 41, 34, 1, 3, 6, 2, 91, 312, 42, 31, 67, 12, 10, 18, 56, 90, 21, 45, 47, 89, 1999999990,
                78, -7, 76, 75, 74, 73, 72, 80, 24, 25, 61, 69, 84, 0, -1, 145, 1902, 200, 199, 198, 197, 196, 195, 194,
                78, 77, 76, 75, 74, 73, 72, 80, 24, 25, 61, 69, 84, 0, -1, 145, 1902, 200, 199, 198, 197, 196, 195, 194,
                5, 71, 23, 41, 34, 1, 3, 6, 2, 91, 312, 42, 31, 67, 12, 10, 18, 56, 90, 21, 45, 47, 89, 1999999990
            };

            long maxSum = maxSumRec(a, 0, a.length-1);
            System.out.println("Max sum is " + maxSum);

            //WITH INTS
            System.out.println("with ints, the sum 1 to 94 is " + sum(a,1,94));
            System.out.println("with ints, the sum 1 to 95 is " + sum(a,1,95));
        }


}