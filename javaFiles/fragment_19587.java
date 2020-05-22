public RandomNumbers(){
    // generating and adding random numbers to the list
    for (int i=0; i<MemoryGame.totalAnswers; i++)
        randomNumberList.add(i);

    Collections.shuffle(randomNumberList);

    System.out.println("Numbers in the list: " + randomNumberList);
    System.out.println("");
}