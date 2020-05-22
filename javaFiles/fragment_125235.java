//match DB answer to selected answer, turn it green if it is correct
if(button1.getText().equals(answerText)){
    button1.setBackgroundColor(Color.GREEN);
} else if(button2.getText().equals(answerText)){
    button2.setBackgroundColor(Color.GREEN);
} else if(button3.getText().equals(answerText)){
    button3.setBackgroundColor(Color.GREEN);
} else if(button4.getText().equals(answerText)){
    button4.setBackgroundColor(Color.GREEN);
}