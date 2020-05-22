public static void main(String[] args) {
    double population[][] = {{281.0, 296.0, 325.0, 371.0, 384.5}, {298.6, 241.2, 301.2, 342.8, 388.7}, {362.9, 284.1, 276.8, 353.6, 395.1}, {393.4, 344.8, 295.6, 298.3, 375.0}};

    //1. Step: Find the longest of the arrays
    //You need this if the length of the arrays is different, for example:
    /*
    double population[][] = {
     {281.0, 296.0, 325.0, 371.0, 384.5},
     {298.6, 241.2, 301.2, 342.8, 388.7, 0},
     {362.9, 284.1, 276.8, 353.6, 395.1, 1, 2},
     {393.4, 344.8, 295.6, 298.3, 375.0, 0.5}
    };
    */
    int lengthOfLongestArray = population[0].length;
    for(int i = 0; i < population.length; i++){
        if(population[i].length > lengthOfLongestArray){
            lengthOfLongestArray = population[i].length;
        }
    }

    //2. Step: calculate the sum
    double result[] = new double[lengthOfLongestArray];
    for(int i = 0; i < population.length; i++){
        for(int j = 0; j < population[i].length; j++){
            result[j] += population[i][j];
        }
    }

    System.out.println(Arrays.toString(result));
}