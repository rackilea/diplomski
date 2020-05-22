File file = new File(PATH_OF_FOLDER + File.separator + <name of the file you clicked>
intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
try {
// try to start the emailActivity
startActivity(Intent.createChooser(intent, "Send mail..."));
} catch (android.content.ActivityNotFoundException ex) {
  //auto-generated
}