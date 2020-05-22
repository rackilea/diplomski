public static void sortStudentScores(String namesArry[], int scoresArry[]) {
    int tempScore;
    String tempName;

    for (int i = 0; i < scoresArry.length; i++) {

        for ( int j= i + 1; j < scoresArry.length; j++) {

            if (scoresArry[i] < scoresArry[j]) {
                tempScore = scoresArry[i];
                scoresArry[i] = scoresArry[j];
                scoresArry[j] = tempScore;
                tempName = namesArry[i];
                namesArry[i] = namesArry[j];
                namesArry[j] = tempName;

            }
        }
    }

    System.out.println("\nDescending Order:");

    for (int i = 0; i < namesArry.length; i ++) {
        System.out.println("Student Name: " + namesArry[i] + " " + 
scoresArry[i]);
    }
}