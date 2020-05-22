textView = findViewById(R.id.textView);
runnable = new Runnable() {
    public void run() {
        if (count <= 1500) {
            textView.setText(String.valueOf(counter));
            count++;
            counter += 10;
            handler.postDelayed(this, 500);
          //500 milliseconds for half a second delay change this as you require
        } else {
            handler.removeCallbacks(this);
        }
    }
};