TextView compareText = (TextView)findViewById(R.id.compareLabel);   
        EditText counter1E = (EditText) findViewById(R.id.textView_totalCalorieIntake);   
        EditText caloriesresultE = (EditText)findViewById(R.id.caloriesText);

        float calorieIntake = Float.parseFloat(counter1E.getText().toString().trim());
        float calorieNeed = Float.parseFloat(caloriesresultE.getText().toString().trim());                      

        float diffValue = calDiff(calorieIntake, calorieNeed);      

        String calInterpretation = interpretDiff(diffValue);

        compareText.setText("Difference of" + diffValue + " : " + calInterpretation);