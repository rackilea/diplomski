new Timer().schedule(new TimerTask(){
    @Override
    public void run() {
        runOnUiThread(new Runnable(){
            @Override
            public void run() {
                letterButton.setText(alphabet[index++]);
            };
        });
    }
}, 0, 1000);