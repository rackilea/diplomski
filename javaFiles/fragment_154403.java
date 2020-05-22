// pseudo-code for simplification
for(nodeA in fileA) {
    for(nodeB in fileB) {
         // check all the aforementioned conditions 
         if(presentInBothIndexB.contains(indexB))
             continue; // skip if it was already recorded
         // else, do all the other stuff - isPresentInBoth = true, and so on