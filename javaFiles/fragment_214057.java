public void sendGmail(Activity activity, String subject, String text) {
    Intent gmailIntent = new Intent();
    gmailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
    gmailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
    gmailIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
    try {
      activity.startActivity(gmailIntent);
    } catch(ActivityNotFoundException ex) {
      // handle error
    }
}