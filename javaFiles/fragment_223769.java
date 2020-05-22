Spannable sb = new SpannableString("Bold text");
sb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

Notification notification = new Notification.Builder()
     .setContentTitle("5 New mails from " + sender.toString())
     .setContentText(subject)
     .setSmallIcon(R.drawable.new_mail)
     .setLargeIcon(aBitmap)
     .setStyle(new Notification.InboxStyle()
         .addLine(str1)
         .addLine(sb);
         .setContentTitle("")
         .setSummaryText("+3 more"))
     .build();