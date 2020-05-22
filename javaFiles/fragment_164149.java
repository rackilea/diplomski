protected void onProgressUpdate(Void... values) {
    Handler handler = new Handler(Looper.getMainLooper());
    handler.post(new Runnable(){
        public void run() {
            myAdapter.notifyDataSetChanged();            
        }
    });

    super.onProgressUpdate(values);
}