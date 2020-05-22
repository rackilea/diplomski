for (int i=0; i<populationArray.length; i++){
    for (int j=0; j<=i; j++) {
        populationArray[i][j] = random.nextInt(5)+1;
        populationArray[j][i] = populationArray[i][j];
    }
}