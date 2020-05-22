int[] lotteryNumbers = new int[numsInLottery];
boolean[] lotteryNumberHasBeenGenerated = new boolean[highestNumber];

for(int i=0;i<highestNumber;i++){ //none of the numbers have been generated at this point
    lotteryNumberHasBeenGenerated[i]=false;
}

for (int i = 0; i < numsInLottery; i++) {
    int random;
    do{
        random=((Double)(Math.random() * highestNumber)).intValue();
    }while(lotteryNumberHasBeenGenerated[random]);

    lotteryNumbers[i] = random;
    lotteryNumberHasBeenGenerated[random]=true; //the number is maked as generated

}