public void showDialog(Activity activity, String title, String message,
                           View.OnClickListener dialogHandler) {
   ...
   button2.setOnClickListener(dialogHandler);
   panel.show();
}