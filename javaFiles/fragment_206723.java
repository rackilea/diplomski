public double getClassAverage(int schoolYear){
    int count = DEFAULT_ZERO;
    double totalScore = DEFAULT_DOUBLE_ZERO;
    for (School student : studentCensus){
        int year = student.getSchoolYear();
        if ( schoolYear == year){
            count++;
            double score = student.getScore();
            totalScore = totalScore + score;
        }
    }
    if (count > 0) {
        return totalScore / count;
    } else {
        return 0;
    }
}