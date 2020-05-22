//inside of onCreate method should work
ll.post(new Runnable() {
    @Override
    public void run() {
        //maybe also works height = ll.getLayoutParams().height;

        height  = ll.getHeight();

    }
});