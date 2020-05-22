public void testNumber(View view)
        {
            EditText usersNumber = (EditText)findViewById(R.id.usersNumber);
            String message = "";
            if(usersNumber.getText().toString().isEmpty()){
                message = "Please enter a number";
            } else {                                // ELSE STARTS HERE...
                Number myNumber = new Number();
                myNumber.number = Integer.parseInt(usersNumber.getText().toString());

                //will display on logcat
                System.out.println(myNumber.isTriangular());

                if(myNumber.isTriangular()){
                    message = myNumber.number + " is triangular" ;
                }
                else{
                    message = myNumber.number + " is not triangular" ;
                }
            }                                       // AND ENDS HERE
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }