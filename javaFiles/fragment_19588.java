public RandomNumbers(){
    // generating and adding random numbers to the list
    for (int i=0; i<32; i++)
        randomNumberList.add(i);

    Collections.shuffle(randomNumberList);

    // keep only the first ones we need
    randomNumberList.removeRange(MemoryGame.totalAnswers + 1, 32);

    System.out.println("Numbers in the list: " + randomNumberList);
    System.out.println("");
}