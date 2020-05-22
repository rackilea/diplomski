new Thread(new loadDataAsync(this)).start();



class loadDataAsync implements Runnable {

    MainActivity mainActivity;

    public loadDataAsync(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        loadData(mainActivity);         
    }
}