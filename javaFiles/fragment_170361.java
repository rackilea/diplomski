public static int getLinnearRandomNumber(int maxSize){
    //Get a linearly multiplied random number
    int randomMultiplier = maxSize * (maxSize + 1) / 2;
    Random r=new Random();
    int randomInt = r.nextInt(randomMultiplier);

    //Linearly iterate through the possible values to find the correct one
    int linearRandomNumber = 0;
    for(int i=maxSize; randomInt >= 0; i--){
        randomInt -= i;
        linearRandomNumber++;
    }

    return linearRandomNumber;
}