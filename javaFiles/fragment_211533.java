static Scanner keyboard = new Scanner(System.in);
          public static void main(String[] args) {

       System.out.println("Please enter a integer? ");
       int x;
       x = keyboard.nextInt();
       int inputnum=x;
              System.out.println("The average is"+computeAvg(inputnum));

        }
         public static double computeAvg(int y)
         {
             double[] arr = new double[y];
       System.out.println(y);
             for (int i = 0; i < y; i++) {
                 System.out.println("Enter double values ");
                 arr[i] = keyboard.nextDouble();
             }
             double sum = 0;
             for(double a:arr){
                 sum +=a;
             }
             System.out.println(sum);
             double average = sum/arr.length;
             return average;
       }