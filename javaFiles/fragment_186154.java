Button button= (Button) findViewById(R.id.NextButton);
    button.setOnClickListener(new OnClickListener() {

        @Override
    public void onClick(View v)  {

         if (imageView1.getVisibility() == View.VISIBLE) {
             imageView1..setVisibility(View.INVISIBLE);
             imageView2..setVisibility(View.VISIBLE);
          }
         else
         {
             imageView1..setVisibility(View.VISIBLE);
             imageView2..setVisibility(View.INVISIBLE);
         }         

        }
        });