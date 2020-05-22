System.out.print("How many numbers would you like to put in the array?: ");
int num = in.nextInt();
int position = 0;
double[] array = new double[num];

while(position < num) {
    System.out.println("Enter the " + num + " numbers now.");
    array[position++] = in.nextDouble();
}