public boolean isNumeric (String s){
    try{
        Double.parseDouble(s);
        return true;
    } catch (Exception e) {
        return false;
    }
}