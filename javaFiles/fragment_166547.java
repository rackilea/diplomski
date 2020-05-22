class Solution {
    public int solution(int[] A) {
        int minAvgIdx=0;
        double minAvgVal=(A[0]+A[1])/2; //At least two elements in A.
        double currAvg;
        for(int i=0; i<A.length-2; i++){
            /**
             * We check first the two-element slice
             */
            currAvg = ((double)(A[i] + A[i+1]))/2;
            if(currAvg < minAvgVal){
                minAvgVal = currAvg;
                minAvgIdx = i;
            }
            /**
             * We check the three-element slice
             */
            currAvg = ((double)(A[i] + A[i+1] + A[i+2]))/3;
            if(currAvg < minAvgVal){
                minAvgVal = currAvg;
                minAvgIdx = i;
            }
        }
        /**
         * Now we have to check the remaining two elements of the array
         * Inside the for we checked ALL the three-element slices (the last one
         * began at A.length-3) and all but one two-element slice (the missing
         * one begins at A.length-2).
         */
        currAvg = ((double)(A[A.length-2] + A[A.length-1]))/2;
        if(currAvg < minAvgVal){
            minAvgVal = currAvg;
            minAvgIdx = A.length-2;
        }
        return minAvgIdx;
    }
}