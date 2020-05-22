int[] sumArray = new int[maxRoll];
for (int i = 0; i < numRol; i++) {
    int sum = 0;
    for (Die d : diceArray) {
        int roll = d.roll();
        sum += roll;
        System.out.print("\t" + roll);
    }
    System.out.println("\t:\t" + sum);
    sumArray[sum-1]++;
}
for (int i  = 0; i < sumArray.length; i++){
    System.out.printf("%d: %d Rolls\n", i+1, sumArray[i]);
}