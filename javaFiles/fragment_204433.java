try {
  mActivity.startActivity(smsIntent);
} catch ( Exception e ) {
    e.printStackTrace();
    // show toast or something so user knows why it is not working
}