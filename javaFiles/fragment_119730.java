activity.runOnUiThread(new Runnable() {
  public void run() {
  new AlertDialog.Builder(mcontext)
       .setTitle("title：")
       .setMessage(TmpPwd)
       .setPositiveButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
        }
    })
    .show();
  }
});