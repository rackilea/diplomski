for(int j = 0; j < grades.length; ++j) {
    int sum = 0;
    for(int i = 0; i < grades[j].length; ++i) sum += grades[j][i];

    average[j] = sum / numGrade;
}