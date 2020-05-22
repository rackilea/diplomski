private class GenerateRunnable implements Runnable {
    public void run() {
        // this code is executed in a background thread.
        // generate the first music
        music = generate(prevmusic, prevmusic.length);
        prevmusic = music;

        // write the midi
        writeMidi(music, song);
        textOut.post(new Runnable() {
            public void run() {
                // this code is executed on the UI thread.
                textOut.setText("Initialising...");
            }
        });
    }
}

@Override
protected void onResume() {
    super.onResume();
    new Thread(new GenerateRunnable()).start();
}