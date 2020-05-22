public double getMaxScore() {
    double maxScore = 0;
    //"students" is the class variable / list you have in your ScoreApp class
    for(Student current: students) {
        double currentScore = current.getScore();
        if(currentScore > maxScore)
            maxScore = currentScore;
    }
    return maxScore;
}