public Target loopTargets() {
    for(int i = 0; i < targets.size(); i++) {
       // sets target in each iteration, but does not use it
       t = targets.get(i); 
    }
    return t; // return the last target set
}