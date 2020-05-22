// initialize array for counting each enumeration type
// TODO: someone should double check every initial value will be zero
int[] cardCount = new int[CardEnum.values().length];
...

// incrementing the count for an enumeration (when we add)
cardCount[BEST_OF_THREE.ordinal()]++;
...

// decrementing the count for an enumeration (when we remove) 
cardCount[BEST_OF_THREE.ordinal()]--;
// DEBUG: assert cardCount[BEST_OF_THREE.ordinal()] >= 0
...

// getting the count for an enumeration 
int count = cardCount[BEST_OF_THREE.ordinal()];