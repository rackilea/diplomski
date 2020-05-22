private final ProgressDialog dialog = new ProgressDialog(YourClass.this);

protected void onPreExecute() {
   this.dialog.setMessage("loading...");
   this.dialog.show();
}