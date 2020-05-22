final Handler handler = new Handler();

handler.post(r);

final Runnable r = new Runnable() {
    public void run() {
        //Do something after 15000ms or 15sec
        //call you getData() method here
        getData();

        //now call the runnable again after 15sec
        //you can also add some condition to stop this

        handler.postDelayed(this, 15000); // 15000 = 15 sec
    }
};