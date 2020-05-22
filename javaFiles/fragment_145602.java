public static void main(String[] args) {

         System.out.println("Enter your choice: 1, 2, 3 etc..");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("1: do your stuff here");
                    //do your stuff here
                    break;

                case 2:
                    System.out.println("2: do your stuff here");
                    //do your stuff here
                    break;

                default:
                    System.out.println("Invalid choice");
           }
    }