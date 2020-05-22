public static Integer[] insertScore(int userInput, Integer[] setScores){
    int newScore = higherThan(setScores);
    for (int i=0; i<=(userInput-1); i++){
        if(setScores[i] < newScore ){
            for (int n=(userInput-2); n>i; n--){
                setScores[n+1] = setScores[n];
            }
            setScores[i] = newScore;
            for(int loop=0; loop<=(userInput-1); loop++){
                System.out.println(setScores[loop]); //***EDITED***//
            }
        }
    }
    return setScores;   
}