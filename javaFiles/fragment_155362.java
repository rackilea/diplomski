// variable at the top
int i = 0;

// code that works
public void nextcard() {        
    i++;

    // checking if it hit the end. Then starting from the beginning
    if (i >= QuesArray.length) {
        i = 0;
    }

    questions.setText(QuesArray[i]);// calling the
}

// code that gives me errors for going back
public void previousCard() {
    --i;

    // checking if it hit the beginning and then starting at the end of the
    // array
    if (i < 0) {
        i = QuesArray.length - 1;
    }

    questions.setText(QuesArray[i]);
}