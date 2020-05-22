choiceBtnA.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        checkAnswers(0);
        ...
    }
});

...

public boolean checkAnswers(int index) {
    String answer = questionArray[randomIndex].choices[index];
    String correctAnswer = questionArray[randomIndex].answer;
    ...
}