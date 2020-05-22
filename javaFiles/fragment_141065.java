public static void sendEmailWithAttachment(Context context) {
    String filename="/scale.csv";
    File filelocation = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);
    //Uri path = Uri.fromFile(filelocation);
    Uri path = FileProvider.getUriForFile(context, "your.application.package.fileprovider", filelocation);
    Intent emailIntent = new Intent(Intent.ACTION_SEND);
    // set the type to 'email'
    emailIntent .setType("vnd.android.cursor.dir/email");
    String to[] = {"email@gmail.com"};
    emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Scale Data");
    emailIntent.putExtra(Intent.EXTRA_TEXT, "This is the body");
    emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    // the attachment
    emailIntent .putExtra(Intent.EXTRA_STREAM, path);
    context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
}