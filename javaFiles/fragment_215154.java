protected void onPostExecute(final Boolean result) {
   if (this.dialog.isShowing()) { // if dialog box showing = true
      this.dialog.dismiss(); // dismiss it
   }
   if (result.booleanValue()) {
      //also show register success dialog
   }
}