@Override
    public void onUpdateReceived(Update update) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (update.hasMessage()) {
                // code goes here.
                }
              }
       }).start
}