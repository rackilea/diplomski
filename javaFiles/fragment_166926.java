public Direction combine(Direction other) 
            throws InsaneDirectionsException{
        Direction res = this.combineMap.get(other);
        if (res == null) {
            throw new InsaneDirectionsException(
                  "Can't combine directions " + this + 
                  " and " + other);
        }
        return res;
    }