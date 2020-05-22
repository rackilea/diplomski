public static void hailstone_Sequence(){
        Scanner user_console = new Scanner(System.in);
        System.out.println("Please provide a starting integer: ");
        int BEGINVALUE = user_console.nextInt();
        System.out.println("Thank you. How long would you liked the sequence to be?");
        int STEPS = user_console.nextInt();
        System.out.println("Calculating..");
        compute_Hailstone_Sequence(BEGINVALUE, STEPS);
    }

public static void compute_Hailstone_Sequence(int begin_num, int steps){
        System.out.print(begin_num + " ");
        for (int i = 1; i < steps; i++ ){
            if (begin_num%2 == 0 ){
                begin_num = (begin_num / 2);
                System.out.print(begin_num + " ");
            }
            else {
                begin_num = (3 * begin_num) + 1;
                System.out.print(begin_num + " ");
            }
        }
    }