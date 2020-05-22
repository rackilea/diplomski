ArrayList<Integer> winningNumber = new ArrayList<Integer>(); //initialize outside for-each loop
for (Integer gn : goodNumbers) {

    if(drawnNumbers.contains(gn)){
          winningNumber.add(gn);
    }

}