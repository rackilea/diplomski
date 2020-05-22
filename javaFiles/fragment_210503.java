public void onClick(View v) {

    switch (v.getId()) {
        case R.id.id1:
        Thread th = new Thread(new Runnable() {
            public void run() {
                //Prepare for further threading.
                Looper.prepare();

                update();
                delObjects();
                addObjects();
            }
        }); 
        th.start();
        break;
    }
}