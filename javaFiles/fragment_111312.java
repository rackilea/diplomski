do {
    System.out.println("Enter Dollars:");
    Scanner in = new Scanner(System.in);
    String d = in.next();
    if ("Q".equalsIgnoreCase(d)) {
        System.out.println("Stop!");
        break;
    } else {
        //check if your input is valid double or not, if not show an error message
        try {
            double ds = Double.parseDouble(d);
            one.setDollar(ds);
            System.out.println("Euro:");
            System.out.println(one.getCurrency());
        } catch (NumberFormatException e) {
            System.out.println("*********Not double*********");
        }
    }
} while (true);