int sum = 0;

    for (int i = 0; i < numberOfGrades; i++) {
        System.out.println("Please enter grade " + (i + 1) + ": ");
        int userGradeNumbers = keyboard.nextInt();
        sum += userGradeNumbers;            
    } 

    int storeGrades[] = new int[userGradeNumbers];