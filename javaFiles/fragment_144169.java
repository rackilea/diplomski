class Task extends TimerTask {

    @Override
    public void run() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                incOpenTime();
            }
        });
    }
}