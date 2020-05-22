recyclerView.post(new Runnable() {
        @Override
        public void run() {
            recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
        }
    });