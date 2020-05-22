String[] cards = {"one", "two", "three", "four", "five"}; // array

   Random random = new Random(); // random object 

   int index = random.nextInt(cards.length); // assign the next random int with a maximum of the array length

   System.out.println(cards[index] + " was selected.");