private double[] values;
private int size;
public MyContainer() {
    values = new double[50];
    size = 0;
}

public void run(){
    // load()
    Scanner input = new Scanner(System.in);
    double sum = 0;
    System.out.print("Enter a positive number, negative number will end entry.");
    double number = input.nextDouble();