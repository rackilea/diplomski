MyActivity.this.runOnUiThread(new Runnable() {

      @Override
      public void run() {
          updateList(uname, msg);
      }
});