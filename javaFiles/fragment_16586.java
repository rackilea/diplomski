public void actionPerformed( ActionEvent ae )
{
    String answer = answerText.getText();
   int answerint = Integer.parseInt(answer);
   if(one + two == answerint){
        correctcounter++;
        System.out.println("correct");
        one = generator.nextInt(11);
        two = generator.nextInt(11);
        // I don't know if you actually store the operator anywhere
        operator = ops[generator.nextInt(4)];
        firstnum.setText("" + one);
           randomOP.setText("" + operator);
           secondnum.setText("" + two);
    }
   else if(one-two == answerint){
       // ... and do the same for the other cases too