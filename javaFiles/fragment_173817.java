final Handler handler=new Handler();
new Thread(new Runnable() {
    @Override
    public void run() {
       //your code
        handler.post(new Runnable() {
            @Override
            public void run() {
                 Parameter.parameterOneVolley(SettingsActivity.this, getApplicationContext());
            }
        });
    }
}).start();