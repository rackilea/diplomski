switch(choice)
            {
                case 1:
                System.out.println("Entering Student Details");
                System.out.println("------------------------");
                System.out.print("   Student name:                               ");
                name = sc.nextLine(); //somewhere here it messes up
sc.nextLine();  // to clean the enter key stored in the buffer
                System.out.print("   Student number:                             ");

                stuNum = sc.nextLine();
            }