public boolean isNumber(String input){
    for (char c : input.toCharArray()){
        if (!Character.isDigit(c))
            return false;
    }
    return true;
}