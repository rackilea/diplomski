try {
   choice = sc.nextInt();
} catch(InputMismatchException e){
        System.out.println("Please enter option between 1-6.");
        sc.next();
        continue;
    }