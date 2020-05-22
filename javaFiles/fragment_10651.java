public static void main(String[]args) {
        Scanner kbReader= new Scanner (System.in);
        int scores[] = new int [100];
        int counter = 0;
        int sum = 0;
        int input = 0;
        do {
            System.out.println("Enter score out of 100 or negative to quit.");
            input=kbReader.nextInt();
             if(input<0) {
                 break;
             }
             else if (input>100) {
                System.out.println("Score must be out of 100");
            } else {
                scores[counter]=input;
                counter++;
                sum+=input;
            }
        } while (input>0);
        if(counter != 0){
            System.out.println("Score\t# of occur...");
            for(int i =0; i<100; i++) {
                System.out.println(i + "\t" + scores[i]);
            };
            System.out.println("The mean score is " +(sum/counter));
        }
    }