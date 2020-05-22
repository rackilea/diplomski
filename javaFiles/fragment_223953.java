public void alertDialog() {
new AlertDialog.Builder(MainMenuActivity.this)
        .setTitle("Message")
        .setMessage("Do you want to exit the from app?")
        .setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    @TargetApi(11)
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                })
        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @TargetApi(11)
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();