public void onStart() {
     super.onStart();
     Button b = (Button) getView().findViewById(R.id.button);
     b.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
             //do stuff
         }
     });
     //Everything else...
 }