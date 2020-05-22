public boolean isNumber(String input){
    try {
        Integer.parseInt(input);
        return true;
    } catch (NumberFormatException ex){
        return false;
    }
}