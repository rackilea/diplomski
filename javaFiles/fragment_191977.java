public boolean isFighterInFleet() {
    for(Ship ship : this.fleet)
        if(ship instanceof Fighter)
            return true;
    return false;
}