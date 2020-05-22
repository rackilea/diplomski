public int getCorrectAnswer(int questionNumberAsked) {
    int answer;

    if (questionNumberAsked == 0)
        answer = answers[0];
    else if (questionNumberAsked == 1)
        answer = answers[1];
    else if (questionNumberAsked == 2)
        answer = answers[2];
    else if (questionNumberAsked == 3)
        answer = answers[3];
    else if (questionNumberAsked == 4)
        answer = answers[4];
    else if (questionNumberAsked == 5)
        answer = answers[5];
    else if (questionNumberAsked == 6)
        answer = answers[6];
    else if (questionNumberAsked == 7)
        answer = answers[7];
    else if (questionNumberAsked == 8)
        answer = answers[8];
    else if (questionNumberAsked == 9)
        answer = answers[9];
    else answer = 0;

    return answer;
}