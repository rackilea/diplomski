builder.setPositiveButton("Help Translate", new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int whichButton) {
      builder.dismiss();
      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.com"));
      startActivity(browserIntent);
       }
    });