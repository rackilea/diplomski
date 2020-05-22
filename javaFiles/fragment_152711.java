Scanner enter = new Scanner(System.in);

    String ID2, PW2, PW = "qwerty123", ID = "theman";
    int entry = 0;
    do {
        entry++;
        System.out.println("Please enter you ID.");
        ID2 = enter.nextLine();
        System.out.println("Please enter your password.");
        PW2 = enter.nextLine();

        if (ID.equals(ID2) && (PW.equals(PW2))) {
            System.out.println("Welcome...");
        } else if (!(ID.equals(ID2)) && ((PW.equals(PW2)))) {
            System.out.println("Try again!");
        } else if ((ID.equals(ID2)) && (!(PW.equals(PW2)))) {
            System.out.println("Try again!");
        } else if (!(ID.equals(ID2)) && !((PW.equals(PW2)))) {
            System.out.println("Try again!");
        }
        if (entry == 3) {
            System.out.println("**Your account has been blocked**");
            break;
        }
    } while (!(ID.equals(ID2)) && !((PW.equals(PW2))));

}