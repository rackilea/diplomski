public static double computeCapital(double capital, int years, double interestRate) {
    if (years == 0) {    
    return capital; 
    }
    else{
    return computeCapital(capital, years-1, interestRate)*(1+interestRate);
    }
}