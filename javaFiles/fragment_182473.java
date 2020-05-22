Scanner input = new Scanner(System.in);
      String string1 = " ";
      System.out.println("Number of students to be entered");
      int s = input.nextInt();
      List<Student> studentList = new ArrayList<Student>();

      for(int i = 0; i<s; i++) {
             System.out.println("Please input full name of student: ");
             string1 = input.next(); // user input of name
             System.out.println("Please input Student ID (if done enter 0): ");
             String string2 = input.next(); // user input of ID
             System.out.println("Please input Students Credits: ");
             int inputCredits = input.nextInt(); // User input of Credits
             System.out.println("Please input Student's Total Grade Points Earned: ");
             double getPoints = input.nextDouble();
             double GPA = getPoints/inputCredits; //User input of Grade Points Earned and Divide by Credits to get GPA

             Student student = new Student(string1, string2, inputCredits, GPA);
             System.out.println( "Name: " + first.getName() + "\nUser ID: " + first.getId() + "\nCredits: " + first.getCredits() + "\nGrade Point Average: " + first.getGradePoints()  );
             studentList.add(student);
       }