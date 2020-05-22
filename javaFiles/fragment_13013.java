myCallback = new AsyncCallback<String>() {
     public void onSuccess(String result) {
         someGuiLabel.setText(result);
     }
 }
 fetchConstraintAsynchronously(myCallback);