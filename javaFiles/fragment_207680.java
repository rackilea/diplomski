public static void input() {
    Scanner s = new Scanner(System.in);
    System.out.println("How many values will be averaged ? : ");
    numOfVals = s.nextInt();
    arr = new double[numOfVals];       // <-- PUT THIS HERE
    for(int i=0; i<arr.length; i++){
            System.out.print("Enter Element No."+(i+1)+": ");
            arr[i] = s.nextDouble();
    }
}