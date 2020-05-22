public static void main(String[] args) {
     String ch = null;
        Scanner input = new Scanner(System.in);

            System.out.println("1- GUEST");
            System.out.println("2- ADMINISTRATOR");
            System.out.println("3- LIBRARIAN");
            System.out.println("4- EXIT");



            boolean test = false;

            while (test == false) {
                 System.out.println("* SELECT CHOICE: ");
                String regex = "\\d+";
                ch = input.next();
                test = ch.matches(regex);
                if (test == false) {
                    System.out.println("There is a problem try again");
                }
                else if(Integer.valueOf(ch) > 4 ||  Integer.valueOf(ch) < 1){
                     System.out.println("Select a number from 1 to 4");
                     test =false;
                }
            }


            if (ch.equals("1"))
                System.out.println("WELCOME GUEST \n");
            else if (ch.equals("2"))
                System.out.println("WELCOME ADMIN \n");
            else if (ch.equals("3"))
                System.out.println("WELCOME LIBRARIAN \n");
            else if (ch.equals("4"))
                System.out.println("THANK YOU , SEE YA SOON");
            else
                System.out.println("\t\n WRONG CHOICE PLEASE ENTER A VALID NUMBAAA \n");



    }