long findGCD(long l1, long l2) {
    //end recursion
    if(l2 == 0){
        return number1;
    }
    return findGCD(l2, l1%l2);
}