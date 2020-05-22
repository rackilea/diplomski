for (int i = 0; i < layoutsList.size(); i++) {
    final String str = layoutsList.get(i);
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Log.d("LevelOneFragment", "tick" + str);
        }
    }, (i+1)*1000);