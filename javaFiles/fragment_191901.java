public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice_user = 0;
        int number_to_search = 4;
        int number_user = 0;

        do{
           System.out.println("*****MENU*****");
           System.out.println("1) Start Play : ");
           System.out.println("2) Exit : ");
           System.out.print("Enter your choice : ");
           choice_user = sc.nextInt();

           int attemps = 5;
           boolean number_found = false;

           switch(choice_user){
               case 1 :
                  System.out.println("Option 1 : ");

                   while(attemps > 0 && !number_found){
                        System.out.println("You have " + attemps + " attemps.");
                        System.out.print("Enter your number : ");
                        number_user = sc.nextInt();

                        if(number_user > number_to_search){
                            System.out.println("Smallest ! ");
                        }
                        else if(number_user < number_to_search){
                            System.out.println("Biggest ! ");
                        }
                        else{
                            number_found = true;
                            System.out.println("Bravo ! ");
                        }
                        attemps--;
                   }
                 break;
                 default:
                       System.out.println("Exit...");
           }
        }while(choice_user != 2);
    }