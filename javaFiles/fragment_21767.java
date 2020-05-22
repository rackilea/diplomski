case "addCard" :
        System.out.println ("Enter Account Name:");
        String cName = scan.nextLine();
        try {
            System.out.println ("Enter Account Start Balance:");
            int cBal = scan.nextInt();
            System.out.println ("Enter Account Number:");
            int cNum = scan.nextInt();
            PPArray.addCard(cName, cBal,cNum);
            scan.nextLine();
        } catch (InputMismatchException nfe) {
            System.out.println("InputMismatchException: Please try again with only the card number. (Ex. 12345");
            break;
        }
        break;