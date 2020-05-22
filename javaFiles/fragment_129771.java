if (x instanceof Comparable && y instanceof Comparable) {
    Comparable c1 = (Comparable) x;
    Comparable c2 = (Comparable) y;        
    if(c1.compareTo(c2) < 0){
        //do stuff
    }
}