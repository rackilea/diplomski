// create the listener to listen for the clicked button.
AlertUtils.Listener listener = new AlertUtils.Listener() {
      @Override
      public void onButtonClicked(int pressedButton) {
        // here you'll receive the button value
        // do something here.
      }
   };

AlertUtils alertUtils = new AlertUtils(getContext(), listener);

// then you're calling the method
alertUtils.ShowAlertWithTwoButtons("title", "message", "yes", "no");