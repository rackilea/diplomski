public void averageGrade() {

    int sum = 0;
    float average = 0.0f;


    for(int i = 0; i < scores.size(); i++)
        sum += scores.get(i);       // Compute total score

    average = (float)sum / scores.size();  // Compute average

    System.out.println(average);
}