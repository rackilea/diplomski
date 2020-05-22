public static final int REQUEST_CODE_MAIL = 1000;

private void startMailIntent(){
    Intent i = new Intent(Intent.ACTION_SEND);
    i.setType("message/rfc822");
    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
    i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
    i.putExtra(Intent.EXTRA_TEXT   , "body of email");
    try {
        startActivityForResult(Intent.createChooser(i, "Send mail..."), REQUEST_CODE_MAIL);
    } catch (android.content.ActivityNotFoundException ex) {
        Toast.makeText(MyActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
    }
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(requestCode == REQUEST_CODE_MAIL){
        if(resultCode == RESULT_OK){
            // Mail was sent.
        } else if(resultCode == RESULT_CANCELED) {
            // Sending was cancelled.
        }
    }
    super.onActivityResult(requestCode, resultCode, data);
}