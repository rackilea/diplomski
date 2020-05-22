check.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
            //Here you must get the text on your EditText
            String Answer = (String) typeh.getText().toString(); //here you have the text typed by the user
            //You can make an if statement to check if it's correct or not
            if(Answer.equals("4") || (Answer.equals("four")))
            {
                //Create a Toast because it's correct
                Toast.makeText(OneActivity.this, "Correct! Going to Level 2...",
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent(OneActivity.this, TwoActivity.class);
                startActivity(i);
                finish();
            }
            else{
                //It's not the correct answer
                Toast.makeText(OneActivity.this, "Wrong! Try Again",
                        Toast.LENGTH_LONG).show();
            }
        }
    });