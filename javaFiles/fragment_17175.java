// 1. Generate your counting array
    //    (give it 101 slots to include all grades from 0 to 100)
    int gradeFrequency = new int[101];
    for (int j = 0; j < 101; j++) {
        gradeFrequency[j] = 0;
    }

    // 2. Parse the file and store the frequency of each grade
    while (gradeFile.hasNextLine()) {
       // get the grade and add 1 to its counter
        int grade = Integer.parseInt(gradeFile.nextLine());
        gradeFrequency[grade]++;
    }