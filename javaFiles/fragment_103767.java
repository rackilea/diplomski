public static int[] sort(double[] scores) {
        int[] scoreIndex = new int[scores.length];
        for(int i = 0; i < scores.length; i++) {
            scoreIndex[i] = i;
        }
        for(int i = 0; i < scores.length; i++) {
            for(int j = i; j < scores.length; j++) {
                if(scores[scoreIndex[j]] > scores[scoreIndex[i]]) {
                    int temp = scoreIndex[j];
                    scoreIndex[j] = scoreIndex[i];
                    scoreIndex[i] = temp;
                }

            }
        }
        double[] copy = new double[scores.length];
        for(int k = 0; k < scores.length; k++) {
            copy[k] = scores[k];
        }
        for(int n = 0; n < scores.length; n++) {
            scores[n] = copy[scoreIndex[n]];
            System.out.println(scores[n]);
        }


        return scoreIndex;
    }