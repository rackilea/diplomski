List<String> usernames = accessClass.setUsernames();
    List<String> passwords = accessClass.setPasswords();

    while(attempts > 0 && !loggedIn) {

        System.out.print("Please enter your username: ");

        user1 = wordScan.next();
        int attempts = 3;
        boolean loggedIn = false;

        attempts = attempts -1;
        if(usernames.contains(user1)){

            System.out.print("Now enter your password: ");

            pass1=wordScan.next();

            if(passwords.contains(pass1)){

                System.out.println("Logged in.");
                System.out.println("Your username is "+user1);
                loggedIn = true;
                random.setSeed(System.currentTimeMillis());
                numGen = random.nextInt(899999)+100000;

                System.out.println("Your access code is: "+numGen);
            }
        }
    }

    if(!loggedIn) {
        System.out.println("Invalid Username or password... Terminating.");
        System.exit(0);
    }

    wordScan.close();
}