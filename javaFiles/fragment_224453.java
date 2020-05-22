public static void main(String[] args) {

    float[] myArray = new float[10];        
    Scanner input = new Scanner(System.in);

    for (int i = 0; i < myArray.length; i++) {
        System.out.println("please enter number");
        myArray[(i)] = input.nextFloat();
    }
    System.out.println(add(myArray)); // need to make this call
}