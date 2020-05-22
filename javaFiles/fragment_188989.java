private int upper = 0;
private int lower = 0;

public int next() {
    if(lower >= values[upper].length){
        upper++;
        lower = 0;
    }
    if(upper >= values.length){
        throw new NoSuchElementException("Reached end");
    }
    int result = values[upper][lower++];
    return result;
}