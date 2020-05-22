private class AutoDemoListener implements View.OnClickListener
  {
    public void onClick(View v)
    {
      Is_AutoDemo_B=true;
      Out("AutoDemoListener");
      switchView(demoView, registrationView);
      startRegistration();
      final Handler handler = new Handler();

      registrationView.symbolButton[2][8].performClick();

      handler.postDelayed(new Runnable() {
          public void run() {
            registrationView.symbolButton[4][13].performClick();
          }
        }, 1000);

      handler.postDelayed(new Runnable() {
          public void run() {
            registrationView.symbolButton[0][1].performClick();
          }
        }, 3000);

      handler.postDelayed(new Runnable() {
          public void run() {
            registrationView.symbolButton[6][18].performClick();
          }
        }, 5000);

      handler.postDelayed(new Runnable() {
          public void run() {
            Is_AutoDemo_B=false;
          }
        }, 5100);

    }
  }