AlertDialog.Builder alert = new AlertDialog.Builder(this);
    alert.setTitle("Title here");

    WebView wv = new WebView(this);
    wv.loadData(<YOURHTML_STING>, "text/html; charset=UTF-8", null);


    alert.setView(wv);
    alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int id) {
            dialog.dismiss();
        }
    });
    alert.show();