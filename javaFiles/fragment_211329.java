final Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "WiFi change detected; updating information...", Snackbar.LENGTH_LONG);
snackbar.setAction("DISMISS", new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      snackbar.dismiss();
    }
  });