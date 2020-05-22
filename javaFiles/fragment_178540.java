public double sumAll(double[] numbers) {
    double result = 0;
    for(int i = 0 ; i < numbers.length; i++){
        result += numbers[i];
    }

    return result;
}