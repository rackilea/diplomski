@Override
public void onClick(View v) {

    if (word.equals(userAnswer)){

        answerOutput.setText("Correct!!");

    }

    else {

        answerOutput.setText("Sorry try again.");
    }

}