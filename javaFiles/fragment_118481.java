switch (choice) {
case 1:    //finish add passenger
    System.out.println(" 1 - Add passenger");
    System.out.println(mySubMenu.displayMenu());
    int subChoice = mySubMenu.getChoice();
    switch (subChoice) {
        case 1:
            try {
                System.out.println("Please enter the passengers forename");
                String aforename = strKeyB.next();
                System.out.println("Please enter the passengers surname");
                String surname = strKeyB.next();

                System.out.println("Please enter the passengers nationality");
                String nationality = strKeyB.next();

                System.out.println("Please enter the passenger age");
                int age = intKeyB.nextInt();
                System.out.println(pass1.pasengerAdd(aforename, surname, nationality, age));
            } catch (Exception ex) {
                System.out.println(ex.toString());

            }
            break;  // here you miss case 1: in switch(subchoice) when exception

        case 2:
            try {
                System.out.println("Please enter the passengers forename");
                String onforename = strKeyB.next();
                System.out.println("Please enter the passengers surname");
                String onSurname = strKeyB.next();
                pass1.pasengerAdd(onforename, onSurname);

            } catch (Exception ex) {
                System.out.println(ex.toString());

            }
            break;

//
// more code until...
//

break; 

case 2:  // here you miss case 1: in switch(choice) 
    try {
        System.out.println(" 2 - Delete Passenger");