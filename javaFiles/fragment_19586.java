public RandomNumbers(){
    HashSet<Integer> set = new HashSet<Integer>();

    // generating and adding random numbers to the list
    //for (int i=0; i<MemoryGame.totalAnswers; i++)
    while (set.size()<MemoryGame.totalAnswers)
        set.add(randomNums.nextInt(32));

    randomNumberList.addAll(set);  // dump the set in your ArrayList

    System.out.println("Numbers in the list: " + randomNumberList);
    System.out.println("");
}