public class Solution {

    public int[] solution(int N, int[] A) {

        int highestCounter = N;
        int maxValue = 0;
        int lastMaxValue = 0;
        int [] answer = new int[N];

        for (int i = 0; i < A.length; i++) {
            int currentCounter = A[i]; 
            int answerEquivalent = currentCounter -1;

            if(currentCounter >0 && currentCounter<=highestCounter){
                if (answer[answerEquivalent] < lastMaxValue)
                    answer[answerEquivalent] = lastMaxValue +1;
                else 
                    answer[answerEquivalent] = answer[answerEquivalent]+1; 

                if(answer[answerEquivalent] > maxValue){
                    maxValue = answer[answerEquivalent];
                }
            }

            if (currentCounter == highestCounter +1){
                lastMaxValue = maxValue;
            }
        }
        // update all the counters smaller than lastMaxValue
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] < lastMaxValue)
                answer[i] = lastMaxValue;
        }
        return answer;
    }

}