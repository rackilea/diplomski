public void lottery() {

    System.out.println("Welcome to the Lottery Number Generator!");
    System.out.println("How many numbers are in your lottery?");
    int numsInLottery = TextIO.getInt();
    System.out.println("What is the highest possible number?");
    int highestNumber = TextIO.getInt();

    int[] lotteryNumbers = new int[numsInLottery];
    boolean[] lotteryNumberHasBeenGenerated = new boolean[highestNumber];

    for(int i=0;i<highestNumber;i++){ //none of the numbers have been   generated at this point
        lotteryNumberHasBeenGenerated[i]=false;
    }

    for (int i = 0; i < numsInLottery; i++) {
        int random;
        do{
            random=((Double)(Math.random() * highestNumber)).intValue();
        }while(lotteryNumberHasBeenGenerated[random]);

        lotteryNumbers[i] = random;
        lotteryNumberHasBeenGenerated[random]=true; //the number is maked as    generated

}

    System.out.println("Lottery numbers:\n" + Arrays.toString(lotteryNumbers));
}