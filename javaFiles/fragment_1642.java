AlertDialog.Builder localBuilder3 =
  localBuilder2.setPositiveButton
  (
    "OK",
    new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        paramDialogInterface.cancel();
        Pokemon.this.setContentView(2130903046);
        Pokemon.this.mainmenu();
      }
    }
  );