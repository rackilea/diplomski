Handler handler = new Handler(Looper.getMainLooper());
    handler.post(new Runnable() {
        public void run() {
            Intent intent = new Intent(context, EndGameActivity.class);
            context.startActivity(intent);
            GameActivity.activity.finish();
        }
    });