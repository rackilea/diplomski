public static void main (String[] args) 
{
    double[][] arr = new double[10][3];
    int ptr = 0;
    Scanner in = new Scanner(System.in);

    while(in.hasNext()) {
        arr[ptr][0] = in.nextDouble();
        arr[ptr][1] = in.hasNext() ? in.nextDouble() : 0d;
        arr[ptr++][2] = in.hasNext() ? in.nextDouble() : 0d;
    }
}