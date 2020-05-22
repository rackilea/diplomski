new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pic.get(0).setImageDrawable(getResources().getDrawable(R.drawable.coin));
            }
        });
    }
}).start();