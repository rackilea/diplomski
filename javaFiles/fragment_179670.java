public double getAverageScore() {
    double averageScore = 0;
    int noOfStudents = 0;
    int sumOfScores = 0;

    for(Student current: students) {
        double currentScore = current.getScore();
        sumOfScores += currentScore;
        noOfStudents++;
        averageScore = sumOfScores / noOfStudents;
    }
    return averageScore;
}