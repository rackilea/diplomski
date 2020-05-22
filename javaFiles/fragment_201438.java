int storeGrades[] = new int[numberOfGrades];
    int sum = 0;

    for (int i = 0; i < numberOfGrades; i++) {
        System.out.println("Please enter grade " + (i + 1) + ": ");
        int grade = keyboard.nextInt();
        storeGrades[i] = grade;
        sum += grade;            
    }