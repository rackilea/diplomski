while(true) {
        if (userNumber.length()==10 && userNumber.matches("\\d*")) {
            System.out.println(userNumber);
            break;
        }
        else if (userNumber.length()!=10 || !userNumber.matches("\\d*")) {
            System.out.println("Invalid phone number, Enter a valid one");
        }
        userNumber=sc.nextLine();
    }