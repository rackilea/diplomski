final Handler handler = new Handler();

Runnable runnable = new Runnable() {
    @Override
    public void run()
    {
        handler.postDelayed(this, 3000);
    }
};

handler.postDelayed(runnable, 3000);