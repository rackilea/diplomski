new Timer().schedule(new TimerTask() {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Intent menuIntent = new Intent(Main.this, menu.class);
        startActivity(menuIntent);
    }
}, 5000);