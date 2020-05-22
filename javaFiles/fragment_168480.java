@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game_play);
    et = (EditText) findViewById(R.id.editText1);
    bt = (Button) findViewById(R.id.b1);
    final boolean is_guess = false;

    bt.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

        int num = 0;
        try {
            num = Integer.parseInt(et.getText().toString());
        } catch (NumberFormatException e) {
            num = 0;
            e.printStackTrace();
        }
             while(is_guess == false) 
             {
              if(num > 100 && num < 0)
              {
            AlertDialog alertDialog = new           AlertDialog.Builder(Play.this).create();
                alertDialog.setTitle("Wrong Input !!");
                alertDialog.setMessage("Please enter the number within the    limit 1 to 100");
                alertDialog.show();
              }
             else if(num > i1)
             {
                Toast.makeText(getApplicationContext(), "Entered number is greater than guessing number", Toast.LENGTH_LONG);
                count++;
             }
             else if(num < i1)
             {
                 Toast.makeText(getApplicationContext(), "Entered number is smaller than guessing number", Toast.LENGTH_LONG);
                    count++;
             }
             else if(num == i1)
             {
                 count++;
                 AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                    alertDialog.setTitle("Congratulations ");
                    alertDialog.setMessage("You Win\n");
                    Log.d("Total", "Attempt = "+count);
                    alertDialog.show();
             }
           }
        }
    });
 }