//This method return a list of lists, where each "inner list" contains as
//its first number the number for which the factors are being found, and
//every other number is a factor.
//It takes an array of all the numbers whose factor you wish to find
public List<List<Integer>> getAllFactors(int[] toCalculate){
    List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
    List<Integer> factors;
    for(int i = 0; i < toCalculate.length; i++){
        factors = new ArrayList<Integer>();
        factors.add(toCalculate[i]); //add the number whose factors will be calculated
        //the square root is used because it is the largest number you can divide by without getting "overlap"
        for(int j = 1; j <= Math.sqrt(toCalculate[i]); j++){ 
            if(toCalculate[i]%j==0){ //if it divides evenly, add it
                factors.add(j);
                factors.add((Integer)toCalculate[i]/j); //also add its "partner" number
            }
        }
        toReturn.add(factors);
    }
    return toReturn;
}