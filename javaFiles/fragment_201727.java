listView.post(new Runnable() {
        @Override
        public void run() {
            listView.smoothScrollToPosition(position);
        }
    });