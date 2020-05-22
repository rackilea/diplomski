String result = A?"0":"A";
try{
    Integer.parseInt(result);
    X();
} catch(NumberFormatException e){
    Y();
}