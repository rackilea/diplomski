public String get(int index){
    //you are missing an '=' in index >= candidates.length
    if (index < 0 || index > candidates.length) {
        throw new RuntimeException("Your argument was not within bounds.");
    }
    //this for loop is wrong, you are changing 'i' but never use it.. 
    //just return candidates[index] like you said before. 
    //It was probably null because of the error above
    for (int i = index; i < candidate.length(); i++){
        candidate = candidates[index];
    }
    return candidate;