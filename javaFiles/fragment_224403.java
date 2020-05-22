final handler = new Handler();

final Runnable r = new Runnable() {
    public void run() {
    if (<EXPRESSION>) {
        // Evaluated true, do your stuff and exit the polling loop.
    } else {
        handler.postDelayed(this, <TIMEOUT>);
    }
}

handler.postDelayed(r, <TIMEOUT>);