try{
    douFrom = Double.valueOf(from);
    douTo = Double.valueOf(to);
}catch(NullPointerException | NumberFormatException ex){
    val = false;
}