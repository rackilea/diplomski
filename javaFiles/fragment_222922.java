public void onClick8 (View view) {
        //here please code for change imagebutton from onClick
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);

        myIntent.putExtra("shouldChangeButton", true);

        startActivity(myIntent);
        finish();
        MediaPlayer mediaPlayer = MediaPlayer.create(zem13.this, R.raw.melody);
        mediaPlayer.start();
}