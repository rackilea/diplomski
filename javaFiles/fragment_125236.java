// match DB answer to selected answer, turn it green if it is correct
ArrayList buttonList = new ArrayList();
buttonList.add(button1);
buttonList.add(button2);
buttonList.add(button3);
buttonList.add(button4);

for(Button button : buttonList){
    if(button.getText().equals(answerText)){
        button.setBackgroundColor(Color.GREEN);
        break;
    }
}