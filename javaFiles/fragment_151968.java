for (int i = 0; i < numberOfKeys; i++) {
    int randomNumber = randomGenerator.nextInt(10000) + 1;
    int location = randomNumber % tableSize;
    if(hashTable[location]==null) {
        hashTable[location] = new LinkedListN();
    }
    hashTable[location].addToEnd(randomNumber);
}