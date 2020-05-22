button1=(ImageButton)findViewById(R.id.button1);
button1.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        try {
                    mp = MediaPlayer.create(Music.this, R.raw.sound);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                } catch (SecurityException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                } catch (IllegalStateException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                }
                try {
                    mp.prepare();
                } catch (IllegalStateException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                }
                mp.start();
        Intent i = new Intent(getApplicationContext(), Activity1.class);
        startActivity(i);
    }

});