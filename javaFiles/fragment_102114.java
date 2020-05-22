public String getVisible() {
    String rtn = null;

    for(Character b: brokenphrases){
        if(characters.contains(b)){
            rtn = rtn + b;
        } else {
            rtn = rtn + "*";
        }
    }

    return rtn;
}