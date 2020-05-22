public int compareTo(Key aKey){
    if(this.equals(aKey)){
        return 0;
    }

    if (StringUtils.isBlank(sometimesPopulated)) {
        if (StringUtils.isNotBlank(aKey.getSometimesPopulated())) {
            return -1;
        }
    } else if (StringUtils.isBlank(aKey.getSometimesPopulated())) {
        return 1;
    } else {
        int result = sometimesPopulated.compareTo(aKey.getSometimesPopulated());
        if (result != 0) {
           return result;
        }
    }
    // same logic with alwaysPopulated
    return 0;
}