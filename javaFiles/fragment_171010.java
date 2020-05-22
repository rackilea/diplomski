public void add(String candidate){
    //if candidate is actually null you are calling null.equals
    //which means this will always result in a NullPointerException
    //you can remove this if if you want
    if (candidate.equals(null)){
        throw new RuntimeException();
    }

    ...

    //think about what you are doing here, 
    //you are setting this.candidates to a new empty array 
    //(is big contenders.length, but still empty) 
    this.candidates = new String [contenders.length];