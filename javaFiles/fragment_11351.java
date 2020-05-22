public static void main(String[] args){
    ArrayList<Double> polynomialCoefficients = new ArrayList<Double>();

    // get data
    ...

    process(polynomialCoefficients);
}

public void process(List<Double> coefficients){
    for(int i = 0; i < coefficients.size(); i ++){
        System.out.println("Element " + i + ": " + coefficients.get(i));
    }
}