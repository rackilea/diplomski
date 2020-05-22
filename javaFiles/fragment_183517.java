buttonCheckAnswer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (!allAnswersChecked())
            intent.putExtra("Key Answer", 1);
        else if (checkAnswers()) 
            intent.putExtra("Key Answer", 2);
        else
            intent.putExtra("Key Answer", 3);
        startActivity(intent);
    }
});