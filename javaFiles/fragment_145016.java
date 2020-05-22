public static boolean isThreeTails(){
    Random rand = new Random();
    int numberOfTosses = 3;
    int numberOfHeads = 0;
    int numberOfTails = 0;

    for(int i = 1; i <= numberOfTosses; i++){
        int value = rand.nextInt(2);
        if(value == 0){
            numberOfTails++;
        }else{
            numberOfHeads++;
        }
    }
    if(numberOfTails == 3){
        return true;
    }
    else{
        return false;
    }
}