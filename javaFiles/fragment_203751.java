normalLayout.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
   normalLayout.setEnabled(false);
   MusicManager.playMusic(getBaseContext(),normalLayout);
}