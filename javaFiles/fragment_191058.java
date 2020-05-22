Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("abc@gmail.com"));
intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
intent.putExtra(Intent.EXTRA_CC, new String[]{"xyz@gmail.com"});
intent.putExtra(Intent.EXTRA_BCC, new String[]{"pqr@gmail.com"});
intent.putExtra(Intent.EXTRA_SUBJECT, "your subject goes here...");
intent.putExtra(Intent.EXTRA_TEXT, "Your message content goes here...");

startActivity(intent);