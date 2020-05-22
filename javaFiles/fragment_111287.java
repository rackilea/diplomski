public void onClick(DialogInterface dialog, int which) {
 final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.clip);
                 mp.start();
                switch(checkedId)
                {
                case R.id.radio0:
                    Toast.makeText(getApplicationContext(),
                            "You got it", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case R.id.radio1:
                    Toast.makeText(getApplicationContext(),
                            "Wrong", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case R.id.radio2:
                    Toast.makeText(getApplicationContext(),
                            "Draw", Toast.LENGTH_SHORT)
                            .show();
                    break;

                }
                }
            }
        );