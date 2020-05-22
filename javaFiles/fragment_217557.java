public void getGame(int diff) {

    String operators [] =  {"+","-","*","/"};
    Random op1, op2, op3, op4, op5, op6;
    if(diff == getIntent().getIntExtra(KEY_DIFFICULTY, DIFFICULTY_NOVICE)){
        op1 = new Random();

        int operator = new Random().nextInt(operators.length);
        String random = (operators[operator]);
        int generate1 = op1.nextInt(10);
        int generate2 = op1.nextInt(10);
        int operation;
        if(  "+".equalsIgnoreCase(random) ){
            operation = generate1 + generate2;
            TextView setProblemToView = (TextView) findViewById(R.id.problem);
            setProblemToView.setText("generate1" + random + "generate2");
        }
    }

}