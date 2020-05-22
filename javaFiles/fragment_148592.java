static double validValueWithRange(Double min, Double max){
   Scanner s = new Scanner(System.in);
   System.out.println("Enter a valid value for a 'double': ");
   double value;
   try {
       value = s.nextDouble();
       if(value > max || value < min){
         System.out.println("Invalid. Try again. Range is 0 - 100");
         return validValueWithRange(min, max);
       }
    }
    catch (InputMismatchException e) {
        System.out.println("Invalid input. Try again.");
        return validValueWithRange(min, max);
    }

    return value;
}

static double validValue(){
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a valid value for a 'double': ");
    double value;
    try {
        value = s.nextDouble();
    }
    catch (InputMismatchException e) {
        System.out.println("Invalid input. Try again.");
        return validValue();
    }

    return value;
}

public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    double tempValue = validValueWithRange(0d, 100d);

    while (true) {
        System.out.println("Now entering endless while loop");
        double sumFocus = 0;
        double[] arrayFocus = new double[2];

        for (int i = 0; i < 2; i++) {
            arrayFocus[i] = validValue();
        }
        for (double num : arrayFocus) {
            sumFocus = sumFocus + num;
        }
    }
}