recyclerView.post(new Runnable() {
        @Override
        public void run() {
            recyclerView.scrollToPosition(adapter.getItemCount() - 1);
            // Here adapter.getItemCount()== child count
        }
    });