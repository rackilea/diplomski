button1.setOnClickListener(new OnClickListener() {
  public void onClick(View v) {

             SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                         moveRight = settings.getInt("rightValue", moveRight) +5;
                        //---------------- moving imageview  ----------------------------------
                        RelativeLayout.LayoutParams params = (LayoutParams) alert.getLayoutParams();
                         params.setMargins(moveRight, 0, 0, 0);
                        alert.setLayoutParams(params);



    }