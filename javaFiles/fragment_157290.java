public void clickDiv(View button){
 try{
     EditText Input = (EditText) findViewById(R.id.editext);

    String input = Input.getText().toString();

     //if no input, set the error to the edittext and return
     if(input.trim().length()==0){
        Input.setError("An input is required");
        return;
     }
     String empty = "";

     Float floatInput = new Float (input);

     TextView TextShow = (TextView) findViewById(R.id.textView1);

     String Newinput = floatInput.toString();

     TextShow.setText(Newinput);

     if (answer == 0){

         answer =  (answer+1) / floatInput  ;
     }else{
         answer =  (answer) / floatInput  ;
     }
     String answerString = answer.toString();

     TextShow.setText(answerString);

     Input.setText(empty); }
     catch (Exception e) {
     AlertDialog alertDialog;
    alertDialog = new AlertDialog.Builder(this).create();
      alertDialog.setMessage("Could not find the operand");
     alertDialog.show();
  }}