public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner input = new Scanner(System.in);
    double[] entered = new double[3]; 
    System.out.println("Enter 3 values to find the maximum:");
    for(int i=0;i<3;i++){
    entered[i] = input.nextDouble();
    }
    System.out.println("Maximum is - " + getMaxValue(entered)); 
}

//Find maximum (largest) value in array using loop
public static double getMaxValue(double[] numbers){
double maxValue = numbers[0];
for(int i = 1; i < numbers.length; i++){
if(numbers[i] > maxValue){
maxValue = numbers[i]; } } return maxValue;

}