for(int i = 0; i < scores.length; i++) {
            for(int j = i; j < scores.length; j++) {
                if(scores[scoreIndex[j]] > scores[scoreIndex[i]]) {
                    int temp = scoreIndex[j];
                    scoreIndex[j] = scoreIndex[i];
                    scoreIndex[i] = temp;
                }

            }
   }