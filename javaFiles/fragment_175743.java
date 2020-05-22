private enum Question { FIRST, SECOND };
private Question current = FIRST; //can also initiate (but not declare) in init()
...
public void actionPerformed(ActionEvent e) {
    if(current == FIRST) {
        questions.setText("How are you " + answers.getText() + "?");
        answers.setText("");
        current = SECOND;
    } else if(current == SECOND) {
        if(answers.getText().equals("well"))
            questions.setText("glad to hear it");
        else
            questions.setText("i'm sorry to hear that");
    }
}