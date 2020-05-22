Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {
        try  {
            //Your HTTP Request goes here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

thread.start();