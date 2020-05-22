import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {

        int numFishes = A.length;

        // no fishes
        if(numFishes == 0)
            return 0;

        // Deque stores the fishes swimming downstreams (B[i]==1) 
        Deque<Integer> downstreams = new ArrayDeque<Integer>();

        for(int i = 0; i < A.length; i++){

            //Fish is going downstreams
            if(B[i] == 1){
                // push the fish into the Deque
                downstreams.push(A[i]); 
            }//Fish is going upstreams
            else{
                while( !downstreams.isEmpty() ){ 
                    // Downstream-fish is bigger 
                    if( downstreams.peek() > A[i] ){
                        //Upstream-fish gets eaten
                        numFishes--;
                        break;    
                    }// Downstream-fish is smaller
                    else if(downstreams.peek() < A[i]){
                        //Downstream-fish gets eaten
                        numFishes--;
                        downstreams.pop();
                    }
                }
            }  
        }    

        return numFishes;
    }
}