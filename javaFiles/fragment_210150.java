Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable()
{
    @Override
    public void run() {
        //Here I can use getApplicationContext() because I'm on the UI Thread Context (I'm using a handler to do so).
        Toast.makeText(getApplicationContext(), "Starting listener...", Toast.LENGTH_SHORT).show();
        startListening();
    }
});