do
    {
        System.out.println("Please enter grade for averaging: ");
        int inputGrade = keyboard.nextInt();
        studentScores[count] = inputGrade;
        count++;
        gradesTotal += inputGrade;

    } while (count < numberOfGrades);