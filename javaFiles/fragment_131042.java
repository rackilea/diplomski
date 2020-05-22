public void onClick(View v) {

    int song = mfile[rnd.nextInt(SOUND_CLIPS)];
    final TextView textOne = (TextView)findViewById(R.id.textView1);
    mpButtonOne = MediaPlayer.create(MainActivity.this, song);


    if (song == mfile[0]){
        textOne.setText("one");
    }