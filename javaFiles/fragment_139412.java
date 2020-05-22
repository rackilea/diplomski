CustomDialog customDialog = new CustomDialog(FirstActivity.this, "Title", "Message", 
new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
           //Do your functionality here.
           Intent intent = new Intent(context, activity.class);
           //Add any flags if you want
           ...
           context.startActivity(intent);

           //Or you can simply do context.finish();
    }
});