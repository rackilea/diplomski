// Create the initial vector
    ICombinatoricsVector<String> initialVector = Factory.createVector(
      new String[] { "red", "black", "white", "green", "blue" } );

   // Create a simple combination generator to generate 3-combinations of the initial vector
   Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 3);

   // Print all possible combinations
   for (ICombinatoricsVector<String> combination : gen) {
      System.out.println(combination);
   }