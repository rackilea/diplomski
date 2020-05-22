public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] ranges  =  { 0,29,39,69,100 };
        int[] inRange = new int[ranges.length - 1];

        int mark;
        do {
            System.out.println("Enter Mark:");
            mark = sc.nextInt();           
            for (int j=1 ; j<ranges.length ; j++)
               if (ranges[j-1] <= mark && mark <= ranges[j]) {
                   inRange[j-1]++;
                   break;
               }
        } while (mark <= 100);

        System.out.println(Arrays.toString(inRange));

        String s = "The number of students that have scored between %d and %d is : ";
        int k = 0;
        for (int i=0 ; i<ranges.length - 1 ; i++) {
          System.out.print(String.format(s,ranges[i] + k,ranges[i + 1]));   
            for (int r = 0; r<inRange[i] ; r++)
                System.out.print("*");
            System.out.println();
            k = 1;
        }

        sc.close();
    }   
}