public void onRestoreInstanceState(Bundle savedInstanceState) {
    // Always call the superclass so it can restore the view hierarchy
    super.onRestoreInstanceState(savedInstanceState);


    // Restore state members from saved instance
    btn1.setText(savedInstanceState.getString("btn1txt"));
    // and so on
}