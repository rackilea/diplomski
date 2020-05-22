Scanner in = new Scanner(System.in);

    //Variables
    int studentId = 0;
    String lastName = "";
    String firstName = "";
    String gradeLetter = "";
    String quit = "";
    double userHomeworkScore = 0.0;
    double userQuizzesScore = 0.0;
    double userMidTermScore = 0.0;
    double userFinalScore = 0.0;
    double homeworkScore = 0.0;
    double quizzesScore = 0.0;
    double midTermScore = 0.0;
    double finalScore = 0.0;
    double totalScore = 0.0;

    do {


        System.out.println("Please enter Student ID");
        studentId = in.nextInt();

        System.out.println("Please enter first name");
        firstName = in.next();



        System.out.println("Please enter last name");
        lastName = in.next();


        System.out.println("Please enter score for the assignments");
        userHomeworkScore = in.nextDouble();

        System.out.println("Please enter score for the quizzes");
        userQuizzesScore = in.nextDouble();

        System.out.println("Please enter score for the midterm");
        userMidTermScore = in.nextDouble();

        System.out.println("Please enter score for the final");
        userFinalScore = in.nextDouble();

        String fullName = (firstName + "," + lastName);

        homeworkScore = (userHomeworkScore * 0.50);
        quizzesScore = (userQuizzesScore * 0.20);
        midTermScore = (userMidTermScore * 0.10);
        finalScore = (userFinalScore * 0.20);

        totalScore = (homeworkScore+quizzesScore+midTermScore+finalScore);

        if (totalScore >= 90)
        {
            gradeLetter = "A";
        }
        else if (totalScore >= 80)
        {
            gradeLetter = "B";
        }
        else if (totalScore >= 70)
        {
            gradeLetter = "C";
        }
        else if (totalScore >= 60)
        {
            gradeLetter = "D";
        }
        else
        {
            gradeLetter = "E";
        }



        //Output
        System.out.println(""+fullName+"");
        System.out.println("Student ID:" + studentId + "");
        System.out.println("Homework:" + homeworkScore + "");
        System.out.println("Quizzes:" + quizzesScore + "");
        System.out.println("Midterm:" + midTermScore + "");
        System.out.println("Final:" + finalScore + "");
        System.out.println("Total Score: " + totalScore + " Grade: " + gradeLetter + "");

        System.out.println("Press any key to enter another student or enter q to quit.");
        quit = in.next();

    }while(!quit.equalsIgnoreCase("q"));