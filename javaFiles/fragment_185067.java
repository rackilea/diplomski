int i = 0;
affected_route.postDelayed(new Runnable() {
    public void run() {
        textView.setText(yourText);
    }
},i+=5000);