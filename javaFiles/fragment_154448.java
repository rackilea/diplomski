recusiveTest(stage6,  new Random());

//overflows after less than 5k invokes
private static boolean recusiveTest(int[][] array, Random rand){
    System.out.println("counter " +isSolvedCounter++);
    array[rand.nextInt(2)][rand.nextInt(2)] = 0;
    return recusiveTest(array, rand);
}