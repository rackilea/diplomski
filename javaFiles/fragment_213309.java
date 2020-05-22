createExternalStoragePublicPicture();
File path = Environment.getExternalStoragePublicDirectory(
                                                Environment.DIRECTORY_PICTURES);
                                        File file = new File(path, "cards_01.pdf");
Intent intent = new Intent(Intent.ACTION_SEND ,Uri.parse("mailto:")); // it's not ACTION_SEND
intent.setType("text/plain");
intent.putExtra(Intent.EXTRA_SUBJECT, "Card Set ");
intent.putExtra(Intent.EXTRA_TEXT, "");
intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(file));
intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
activity.startActivity(intent);