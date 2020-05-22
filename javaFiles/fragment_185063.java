Intent sendIntent = new Intent(Intent.ACTION_VIEW);
sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "email@gmail.com" });
sendIntent.setData(Uri.parse("email@gmail.com"));
sendIntent.putExtra(Intent.EXTRA_SUBJECT, "enter subject");
sendIntent.setType("plain/text");
sendIntent.putExtra(Intent.EXTRA_TEXT, "Insert text");
startActivity(sendIntent);