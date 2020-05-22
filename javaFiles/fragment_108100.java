Runnable saleVoucherRunnable = new Runnable(){
    @Override
    public void run(){
        // get data...
        Activity.this.runOnUiThread(new Runnable(){
            @Override
            public void run(){
                // update some views with the data
                View view = findViewById(...);
                view.setText(...);
            }
        });
    }
};