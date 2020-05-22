private int prevIndex = -1;

private String pickDefaultResponse() {
    int index = 0;
    do {
        index = randomGenerator.nextInt(defaultResponses.size());
    } while( index == prevIndex );
    prevIndex = index;
    return defaultResponses.get(index);                
}