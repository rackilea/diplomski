while(true){
  System.out.println("Main Menu"); // <-- Added based on your edit.
  System.out.println("1. Hourly Employees");
  System.out.println("2. Salary Employees");
  System.out.println("3. Commission Employees");
  System.out.println("4. Weekly Calculations");
  System.out.println("5. Exit Program");
  int choice = userChoice.nextInt(); // <-- HERE
  switch(choice){