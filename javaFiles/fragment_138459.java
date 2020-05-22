while (!valid) { 
    System.out.println("Enter number between 1 and 20: ");

    if (scan.hasNextInt()) {    
        userNumber = scan.nextInt();
        valid = true;   
    } else 
        System.out.print("Not an int. ");
        scan.next(); // Skip a token
    }
}