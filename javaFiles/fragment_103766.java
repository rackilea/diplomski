double[] copy = new double[scores.length];
        for(int k = 0; k < scores.length; k++) {
            copy[k] = scores[k];
        }
        for(int n = 0; n < scores.length; n++) {
            scores[n] = copy[scoreIndex[n]];
            System.out.println(scores[n]);
        }