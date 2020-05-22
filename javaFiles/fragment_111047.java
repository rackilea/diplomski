totalItemsToAdd = 40 //as calculated via baseCombo.sumOfEntries()


for (i=0; i<maxApples; i++) {
    combo = clone the base combination
    combo.apples += i;
    remainingItemsToAdd = totalItemsToAdd - i;
    if (remainingItemsToAdd > 0) {
        for (j=0; j<maxPears; j++) {
            combo.pears += j;
            // and so on, recursively
        }
    }

    results.append(combo)
}