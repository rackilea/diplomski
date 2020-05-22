for (int i=0; i < studentAnswers[i].length; ++i) {
    int score = 0;
    for (int j=0; j < studentAnswers.length; ++j) {
        if (studentAnswers[j][i] == keys[j]) {
            ++score;
        }
    }

    DecimalFormat df = new DecimalFormat(".##");
    double average = (double)score / studentAnswers.length;
    System.out.println("Student number " + i + " score was: " + df.format(average));
}