public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int num = 0;
        int missingTrack = 0;
        System.out.println("Enter number of sequence:");
        int n = scan.nextInt();
        int id[] = new int[n];
        int missing[] = new int[10];

        for(int i=0; i<n; i++) {
            System.out.printf("Enter number %d:",i+1);
            id[i] = scan.nextInt();
        }

        for(int i=0; i<n; i++) {

            //Stop to check when the loop reach the last number in the sequence.
            if(i==n-1)
            {
                break;
            }
            //Assign the different between the next number to identify the missing number
            num = id[i+1]-id[i];

            //Loop based on the difference we get from "num"
            for(int y = 1;y<num;y++)
            {
                //Evaluate and store the missing number into the array
                missing[missingTrack] = id[i]+y;
                missingTrack = missingTrack+1;
            }

        }   
        System.out.println("Missing input: ");
        for(int i=0; i < missingTrack; i++) {
            System.out.print(missing[i]+" ");
        }

}