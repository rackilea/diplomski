editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
       @Override
       public boolean onEditorAction(EditText v, int actionId, KeyEvent event) {
       if (actionId == EditorInfo.IME_ACTION_DONE) {
          view.performClick();
          return true;
       }
       return false;
       } 
   });