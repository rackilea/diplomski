public static void main (String[] args) {

        int input = 0;


        // Creating our objects
        Scanner console = new Scanner(System.in);
        Math math = new Math();

        System.out.println("Welcome to Spin Game!");
        System.out.println("Please write '1' to spin, or -1 to exit.");

        //The input the user wrote..

        input = console.nextInt();

        while(input == 1) {                
            int number = math.calculate(math.number());

            if (number < 30)
            {
                System.out.println("You just won the game!");
            }
            else
            {
                System.out.println("You lost..");                   
            }
            input = console.nextInt();
        }
    }