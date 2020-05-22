public static void sendEmail(final Activity activity,final String email) {

    /* Create the Intent */
    final Intent emailIntent = new Intent(
            android.content.Intent.ACTION_SEND);

    /* Fill it with Data */
    emailIntent.setType("plain/text");
    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
            new String[] {email });
    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
            "Feedback");

    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
    /* Send it off to the Activity-Chooser */
    activity.startActivity(Intent.createChooser(emailIntent,
            "Send feedback"));
}