Button b = (Button) findViewById(R.id.button1);
b.setOnClickListener(new OnClickListener() 
{

    @Override
    public void onClick(View arg0) {
      if(mp = null)
      {
        mp = MediaPlayer.create(MainActivity.this, R.raw.crash);
        mp.start();
        mp.setLooping(true);
      }
      else
      {
        if(mp.isPlaying())
        {
          mp.stop();
          mp = null;
        }
      }
}
});