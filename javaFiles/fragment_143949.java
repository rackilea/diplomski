new CountDownTimer(result, 1000) {

     public void onTick(long millisUntilFinished) {
          time.setText(("seconds remaining: " + millisUntilFinished / 1000));
          //create HashMap<Integer,String> textMap at the constructer of the adapter
          //whenever you want to clear a record clear the hash map
          //now fill this info into it
          textMap.put(new Integer(position),"seconds remaining: " + millisUntilFinished / 1000);
          //notify about the data change
          notifyDataSetChanged();
     }

     public void onFinish() {
          time.setVisibility(View.INVISIBLE);
          Toast.makeText(getApplicationContext(), "finish", Toast.LENGTH_LONG).show();
          if (rowView != lastview || mediaPlayer == null) {
                play(position);
                if (lastview != null)
                     lastview = rowView;
                } else {
                     play.setImageResource(R.drawable.n_btn_play_unselected);
                     mediaPlayer.release();
                     lastview = null;
                }


          }

}.start();