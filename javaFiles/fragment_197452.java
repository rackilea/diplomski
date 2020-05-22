boolean check;

    protected void onCreate(Bundle blah) {
      super(blah);
      check = true;
      // whatever else
    }

    protected void onResume() {
      if(check) {
        isOnline();
        // Everything else

        check = false;
      }
      super.onResume();
    }

    protected void onPause() {
      check = true;
      super.onPause();
    }