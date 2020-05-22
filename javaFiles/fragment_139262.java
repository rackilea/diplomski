// method to be called on onClick
    public void calculateResult(View view) {

// check if EditText is empty
        if (hourlyWage.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter The Value.", Toast.LENGTH_LONG).show();
            return;
        }
// check if EditText is empty
        if(totalRegularHours.getText().toString().isEmpty())
        {
           Toast.makeText(this, "Please Enter The Value.", Toast.LENGTH_LONG).show();
           return;
        }

        int regularHours = Integer.parseInt(totalRegularHours.getText().toString());

        int overtimeHours;
        overtimeHours = Integer.parseInt(totalOvertimeHours.getText().toString());

// check if EditText is out of range
        if (regularHours <= 0 && regularHours >= 40) {

            Toast.makeText(this, "Please Enter The Value of Hours Between 0 to 40.", Toast.LENGTH_LONG).show();

        }
// check if EditText is out of range
        else if (overtimeHours <= 0 && overtimeHours >= 30) {

            Toast.makeText(this, "Please Enter The Value of Hours Between 0 to 30.", Toast.LENGTH_LONG).show();

        }
// calculates the answer
        else if(regularHours >= 0 && regularHours <= 40) {
// formula for calculation
          double regularWage;
          regularWage = (Integer.parseInt(hourlyWage.getText().toString()) * Integer.parseInt(totalRegularHours.getText().toString())) + (Integer.parseInt(totalOvertimeHours.getText().toString()) * Integer.parseInt(hourlyWage.getText().toString()) * (1.5));
//displays the result in a TextView
          result.setText(String.valueOf(regularWage));
        }


    }