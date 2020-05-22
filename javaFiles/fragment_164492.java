ScrollView s = (ScrollView) findViewById(R.id.s);
TextView a = (TextView) findViewById(R.id.a);
s.post(new Runnable() {
    public void run() {
        int[] location = new int[2];
        a.getLocationInWindow(location);
        int y = location[1];
        s.getLocationInWindow(location);
        s.scrollTo(0, y-location[1]); // or some other calculation
    }
});