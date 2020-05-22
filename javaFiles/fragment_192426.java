while (!success) {
        try {
            sh = sc.nextShort();
            while (sh < 1 || sh > 100) {
                System.out.print("You must enter a value between 1-100: ");
                sh = sc.nextShort();
            } //close try
            System.out.println("Great job!");
            success = true; //escape the while
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
            sc = new Scanner(System.in);
        } //close catch
    }