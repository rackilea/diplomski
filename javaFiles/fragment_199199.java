Scanner turtle = new Scanner(System.in);
      String[] calender = { "S", "M", "T", "W", "Th", "F", "S" };
      System.out.println("How many Employee's do you have?: ");
      int NUMBER_OF_EMPLOYEES = turtle.nextInt();
      turtle.nextLine();

      int [][]hours;
      int []totalHours= new int[NUMBER_OF_EMPLOYEES];

      hours = new int[NUMBER_OF_EMPLOYEES][7];
      String[] employee = new String[NUMBER_OF_EMPLOYEES];

      // input for Names
      for (int x = 0; x < (employee.length); x++) {
          System.out.println("Name of Employee " + (x + 1) + ": ");
          String name = turtle.nextLine();
          employee[x] = name;

      }
      // input for Hours
      for (int z = 0; z < employee.length; z++) {
          System.out.println("Starting from Sunday, enter the hours Employee "+ (z + 1)+ " has worked each day (Make sure you seperate it by spaces): ");
          for (int a = 0; a < 7; a++) {
              hours[z][a] = turtle.nextInt();
          }
          turtle.nextLine();
     }
      // Print everything out
      for (int i = 0; i < employee.length; i++) {
          totalHours[i]=0;
          for(int j=0; j<7; j ++){
              totalHours[i] = totalHours[i]+hours[i][j];   
          }

        System.out.println("Employee " + (i + 1) +" worked " + totalHours[i] + " hours");  

      }