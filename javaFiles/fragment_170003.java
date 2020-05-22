private final Map<String, Set<Integer>> validCombinations = initializeMap();
// initialize the map once

// later, in your code:

return validCombinations.containsKey(actionReq) && 
(actionDefault || validCombinations.get(actionReq).contains(actInt));