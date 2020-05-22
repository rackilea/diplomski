int user; 
    double userChange;
    boolean stop = false;

    // check for invalid input if not integer and if out of range
    // interaction with user
    while (!stop){
        try {
            System.out.println("What you want to change?");
            user = sc.nextInt();
            if (user ==3){
                    stop = true;
                }

            while (user !=3){
                if (user ==1){
                    System.out.println("What angle I should set?");
                    userChange = sc.nextDouble();
                    shot.userAngle(userChange);
                    shot.show();
                }
                else if (user ==2){
                    System.out.println("What speed I should set?");
                    userChange = sc.nextDouble();
                    shot.userSpeed(userChange);
                    shot.show();
                }

                else {
                    System.out.println("Wrong number!");
                }
                System.out.println("What you want to change?");
                user = sc.nextInt();
                if (user ==3){
                    stop = true;
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println(e);
            System.out.println("Wrong input! Number but not a symbol or a character!");
            sc.next();

        }
    }