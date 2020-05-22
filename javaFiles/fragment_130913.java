@Override
          public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {

          //Check for succesful result code
          //replace getResources().getInteger(R.integer.success) with the actual resultCode
          if (resultCode == getResources().getInteger(R.integer.success)) {
            //Show your Toast when the result is a success.
            Toast toast = Toast.makeText(getApplicationContext(),
                "Picture was taking", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 100, 0);
            toast.show();
          }
        }
      }