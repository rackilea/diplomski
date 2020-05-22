try {
            temp = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next(); // ignore whatever the user typed that wasn't an integer
            System.out.println("Try again!");
        }