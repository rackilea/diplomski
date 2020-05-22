if (!ServiceHandler.isOnline(getApplicationContext())) {
Handler handler = new Handler(Looper.getMainLooper());
handler.post(
    new Runnable()
    {
        @Override
        public void run()
        {
            MessageHandler.showMessage("You are not online.",
                        getApplicationContext());
        }
    }
);
}