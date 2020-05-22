final Button button = findViewById(R.id.button);

final Runnable runnable = new Runnable() {
  @Override public void run() {
    // Replace with your logic.
    button.setOnClickListener(null);
  }
};

button.setOnClickListener(new View.OnClickListener() {
  @Override public void onClick(final View view) {
    //Removing 5 Seconds timer which will remove click listener.
    view.removeCallbacks(runnable);
  }
});

//Removed Click Listener after 5 Seconds.
button.postDelayed(runnable, 5000);