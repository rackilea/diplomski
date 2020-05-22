for (int i=0; i <= 2; i++) {
    String line = "";
    while (true) {
        System.out.println("Enter class number: ");
        line = sn.nextLine();
        try {
            cn = Integer.parseInt(line);
            break;
        } catch(Exception e) {
            System.out.println("Enter class number as an integer only.");
        }
    }
    while (true) {
        System.out.println("Enter numeric grade: ");
        line = sn.nextLine();
        try {
             ngrade = Integer.parseInt(line);
             break;
        } catch(Exception e) {
            System.out.println("Enter numeric grade as an integer only.");
        }
    }

    System.out.println("Letter Grade: ");

    if (ngrade >= 90) {
        System.out.println("A");
    }        
    else {
         System.out.println("HELLO");
    }

    test = true;
}