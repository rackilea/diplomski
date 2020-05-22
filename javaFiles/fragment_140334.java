public List<Integer> getAllFactors(int number){
    List<Integer> factors = new ArrayList<Integer>();
    for(int i = 2; i <= Math.sqrt(number); i++){
        if(number%i==0){
            factors.add(number);
            factors.addAll(getAllFactors(i));
            factors.addAll(getAllFactors(number/i));
        }
    }
    if(factors.isEmpty())
        factors.add(number);
    return factors;
}