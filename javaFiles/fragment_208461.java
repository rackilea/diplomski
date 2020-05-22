runOnUiThread(new Runnable() {
    @Override
    public void run() {
        recyclerViewAdapter.updateData(lstNews);
    }
});