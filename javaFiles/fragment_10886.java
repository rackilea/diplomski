try { 
        choice = sc.nextInt();
    } catch ( java.util.InputMismatchException e ) {
        System.out.println(e);
        sc.nextLine(); // skip the entire line
        break;
    }