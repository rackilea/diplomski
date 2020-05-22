public double convert(String newTypeOne, String newTypeTwo, double newValueOne){
    if (newTypeOne.equalsIgnoreCase("mm") && newTypeTwo.equalsIgnoreCase("cm")){
        return mmToCm(newValueOne);
    }else if (...){
        return ...;
    }
    :
    : ... and so on
}